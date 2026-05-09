package com.bigsquare.user.service.external.services;

import com.bigsquare.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {


//    get


//    post

    @PostMapping("/ratings")
    public Rating createRating(@RequestBody Rating values);

    //    put
    @PutMapping("/ratings/{ratingId}")
    public Rating updaterating(@PathVariable String ratingId,@RequestBody Rating rating);


    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);

}
