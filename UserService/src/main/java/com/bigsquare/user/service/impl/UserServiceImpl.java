package com.bigsquare.user.service.impl;

import com.bigsquare.user.service.entities.User;
import com.bigsquare.user.service.exceptions.ResourceNotfoundException;
import com.bigsquare.user.service.repositories.UserRepository;
import com.bigsquare.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
//        unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotfoundException("User with given id is not found on the server"+id));
    }
}
