package com.example.homeWorkUserManager.controller;


import com.example.homeWorkUserManager.dto.UserDto;
import com.example.homeWorkUserManager.repositoty.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid UserDto form, Errors errors){
        if(errors.hasErrors())
            return "registration";
        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
