package com.bigsquare.user.service.controllers;

import com.bigsquare.user.service.entities.User;
import com.bigsquare.user.service.impl.UserServiceImpl;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

//    create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.saveUser(user));
    }

//    single user get

    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        return ResponseEntity.ok(this.userServiceImpl.findUserById(userId));
    }

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

        logger.info("Fallback execute ho raha hai kyunki service down hai: {} ", ex.getMessage());
        User user = User.builder()
                .name("Dummy User")
                .about("This dummy user is created because some service is down !!")
                .email("dummy@gmail.com")
                .userId("13123")
                .build(); // Dummy user ya partial data
//        user.setName("Dummy User (Service Down)");
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

//    all user get

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userServiceImpl.getAllUser());
    }

}
