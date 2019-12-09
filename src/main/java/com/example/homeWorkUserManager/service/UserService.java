package com.example.homeWorkUserManager.service;


import com.example.homeWorkUserManager.model.User;
import com.example.homeWorkUserManager.repositoty.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  UserRepository userRepository;
    private User user;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

//    public Optional<User> findUsersById(Long id){
//        return userRepository.findById(id);
//    }

}
