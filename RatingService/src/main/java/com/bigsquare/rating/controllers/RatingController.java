package com.bigsquare.rating.controllers;

import com.bigsquare.rating.entities.Rating;
import com.bigsquare.rating.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingServiceImpl ratingService;

//    create
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.ok(this.ratingService.createRating(rating));

    }

//    get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(this.ratingService.getAllRatings());
    }

//    get ratings by user
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId){
        return ResponseEntity.ok(this.ratingService.getRatingByUserId(userId));
    }

//    get ratings by hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId){
        return ResponseEntity.ok(this.ratingService.getRatingsByHotelId(hotelId));
    }

//    get rating by id
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(this.ratingService.getById(id));
    }

}
