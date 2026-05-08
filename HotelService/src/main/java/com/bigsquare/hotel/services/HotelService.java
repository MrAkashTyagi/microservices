package com.bigsquare.hotel.services;

import com.bigsquare.hotel.entities.Hotel;
import java.util.List;

public interface HotelService {


    //create

    Hotel saveHotel(Hotel hotel);


//    get all hotels
    List<Hotel> getAllHotels();

//    get hotel by id

    Hotel getHotelbyId(String id);
}
