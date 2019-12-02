package com.example.homeWorkUserManager.controller;

import com.example.homeWorkUserManager.model.Role;
import com.example.homeWorkUserManager.model.User;
import com.example.homeWorkUserManager.repositoty.UserRepository;
import com.example.homeWorkUserManager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    private UserService userService;
    private UserRepository userRepository;

    public HomeController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/usermanager")
    public String managerPage(){

        return "usermanager";
    }

    @GetMapping("/userpage")
    public String userPage(){
        return "userpage";
    }
    @GetMapping("/logout")
    public String logoutPage(){
        return "logout";
    }
    @GetMapping("/facebook")
    public String facebookPage(){
        return "facebook";
    }
    @GetMapping("/instagram")
    public String instagramPage(){
        return "instagram";
    }
    @GetMapping("/vk")
    public String vkPage(){
        return "vk";
    }
    @GetMapping("/youtube")
    public String youtubePage(){
        return "youtube";
    }

    @RequestMapping(value = "/redirectPage", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirect(Model model){
        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Role.ROLE_ADMIN)) {
            model.addAttribute("allusers", userService.getAllUsers());
            return "usermanager";
        }
        return "userpage";
    }

//    @RequestMapping(value = "/usermanager", method = RequestMethod.POST)
//    public  String authorisedPages(){
//        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Privileges.PRIVILEGE_FACEBOOK))
//            return "facebook";
//        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Privileges.PRIVILEGE_YOUTUBE))
//            return "youtube";
//        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Privileges.PRIVILEGE_VK))
//            return "vk";
//        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(Privileges.PRIVILEGE_INSTAGRAM))
//            return "instagram";
//        return "userpage";
//    }

    @PostMapping("/update/{id}")
    public String save(@PathVariable (value="id") User user){

            return "login";
    }



}
