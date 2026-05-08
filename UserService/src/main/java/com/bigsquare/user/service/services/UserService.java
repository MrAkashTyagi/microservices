package com.bigsquare.user.service.services;

import com.bigsquare.user.service.entities.User;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public interface UserService {

//    user operations

//    create
    public User saveUser(User user);

//    get all users
    public List<User> getAllUser();

//    get single user by id
    User findUserById(String id);

}
