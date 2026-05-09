package com.bigsquare.user.service;

import com.bigsquare.user.service.entities.Rating;
import com.bigsquare.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RatingService ratingService;

    @Test
    void createRating() {

        Rating rating = Rating.builder().rating("9")
                .userId("b10f6b01-3e65-41c8-8036-2e2571be16e2")
                .hotelId("a548e0ca-01dd-4d44-a6d5-5e4b47aaedcb")
                .feedback("This is created using feign client").build();
        Rating savedRating = ratingService.createRating(rating);
        System.out.println("New Rating created");
    }

}
