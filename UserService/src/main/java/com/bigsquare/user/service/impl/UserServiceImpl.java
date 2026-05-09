package com.bigsquare.user.service.impl;

import com.bigsquare.user.service.entities.Hotel;
import com.bigsquare.user.service.entities.Rating;
import com.bigsquare.user.service.entities.User;
import com.bigsquare.user.service.exceptions.ResourceNotfoundException;
import com.bigsquare.user.service.external.services.HotelService;
import com.bigsquare.user.service.repositories.UserRepository;
import com.bigsquare.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
//        unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
//        implement rating service call using rest template
        return userRepository.findAll();
    }

    //    get single user
    @Override
    public User findUserById(String id) {
//get user from the database with use of user repository
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotfoundException("User with given id is not found on the server" + id));

//        fetch ratings of the above user from RATING SERVICE
//        localhost:8083/ratings/users/a82d7dbb-96f4-4a80-86d9-2d7562011dfd

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("forObject: {}", ratingsOfUser);


        List<Rating> ratingList = Arrays.stream(ratingsOfUser).map(rating -> {

//            api call to hotel mservice to get the hotel

//            http://localhost:8082/hotels/a548e0ca-01dd-4d44-a6d5-5e4b47aaedcb

//            ResponseEntity<Hotel> hotelByHotelId = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelByHotelId.getBody();

            Hotel hotel = hotelService.getHotel(rating.getHotelId());

//            logger.info("response status code{}", hotelByHotelId.getStatusCode());
//            set the hotel to rating
            rating.setHotel(hotel);

//            return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
