package com.bigsquare.user.service.impl;

import com.bigsquare.user.service.entities.Rating;
import com.bigsquare.user.service.entities.User;
import com.bigsquare.user.service.exceptions.ResourceNotfoundException;
import com.bigsquare.user.service.repositories.UserRepository;
import com.bigsquare.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

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

        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
        logger.info("forObject: {}", ratingsOfUser);

        user.setRatings(ratingsOfUser);

        return user;
    }
}
