package com.bigsquare.hotel.controllers;

import com.bigsquare.hotel.entities.Hotel;
import com.bigsquare.hotel.impl.HotelServiceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    //    create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.saveHotel(hotel));
    }

    //    get single hotel
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String id) {
        return ResponseEntity.ok(this.hotelService.getHotelbyId(id));
    }

//    get all hotels

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(this.hotelService.getAllHotels());
    }

}
