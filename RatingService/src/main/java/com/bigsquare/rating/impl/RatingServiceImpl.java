package com.bigsquare.rating.impl;

import com.bigsquare.rating.entities.Rating;
import com.bigsquare.rating.exception.ResorceNotFoundException;
import com.bigsquare.rating.repositories.RatingRepository;
import com.bigsquare.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public Rating getById(String id) {
        return this.ratingRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException());
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return this.ratingRepository.findByHotelId(hotelId);
    }
}
