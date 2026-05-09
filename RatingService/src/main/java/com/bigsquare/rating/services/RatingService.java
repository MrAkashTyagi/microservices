package com.bigsquare.rating.services;

import com.bigsquare.rating.entities.Hotel;
import com.bigsquare.rating.entities.Rating;

import java.util.List;

public interface RatingService {

//    create

    Rating createRating(Rating rating);

//    get by id
    Rating getById(String id);

//    get all ratings
    List<Rating> getAllRatings();


//    get all  by user id
    List<Rating> getRatingByUserId(String userId);

//    get all by hotel id

    List<Rating> getRatingsByHotelId(String hotelId);
}
