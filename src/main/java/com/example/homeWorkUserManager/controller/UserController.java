package com.example.homeWorkUserManager.controller;


import com.example.homeWorkUserManager.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/user")
    public UserDto user() {
        return new UserDto();
    }
}

