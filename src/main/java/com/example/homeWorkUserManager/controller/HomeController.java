package com.example.homeWorkUserManager.controller;

import com.example.homeWorkUserManager.model.Privileges;
import com.example.homeWorkUserManager.model.Role;
import com.example.homeWorkUserManager.model.User;
import com.example.homeWorkUserManager.repositoty.UserRepository;
import com.example.homeWorkUserManager.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


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
            model.addAttribute("user", new User());
            model.addAttribute("allusers", userService.getAllUsers());

//            List<UserPriviledge> userPriviledges = new ArrayList<>();
//
//            for ( User u : userService.getAllUsers()){
//                userPriviledges.add(new UserPriviledge(u.getId(), u.getPrivileges()))    ;
//            }
//            model.addAttribute("userPriviledges",userPriviledges);

            return "usermanager";
        }
        return "userpage";
    }

//    @RequestMapping(value= "/update/{id}", method = {RequestMethod.GET, RequestMethod.POST})
//    public String editapl(@PathVariable("id") Long id, Model model ) {
//        model.addAttribute("user", userService.findUsersById(id));
//        return  "login";
//    }


    @PostMapping(value= "/update/{id}")
    public String updateUser(@PathVariable("id") User user){

        userRepository.save(user);

        return "login";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String display( Model model) {
        List<Privileges> privileges = Arrays.asList(Privileges.values());
        model.addAttribute("privileges",privileges);
        return "login";
    }


//
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





}
