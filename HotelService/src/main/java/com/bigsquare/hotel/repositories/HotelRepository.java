package com.bigsquare.hotel.repositories;

import com.bigsquare.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

//    custom finder mehtods if any

}
