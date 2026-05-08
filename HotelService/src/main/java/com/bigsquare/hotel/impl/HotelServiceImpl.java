package com.bigsquare.hotel.impl;

import com.bigsquare.hotel.entities.Hotel;
import com.bigsquare.hotel.exceptions.ResourceNotFondException;
import com.bigsquare.hotel.repositories.HotelRepository;
import com.bigsquare.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
//create
    @Override
    public Hotel saveHotel(Hotel hotel)
    {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelbyId(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFondException());
    }
}
