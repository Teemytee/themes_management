package com.example.springthymeleaf.controller;

import com.example.springthymeleaf.model.User;
import com.example.springthymeleaf.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/getProfilePage")
    public String getProfilePage(Model model, Principal principal){
        model.addAttribute("text", "My profile");
        model.addAttribute("user", userDetailsService.getUserByEmail(principal.getName()));
        return "profilePage";
    }

    @PostMapping("/uploadProfileImage")
    public String uploadProfileImage(Model model, Principal principal){
        model.addAttribute("text", "My profile");
        model.addAttribute("user", userDetailsService.getUserByEmail(principal.getName()));
        return "redirect:/profilePage";
    }

    @GetMapping("/profileEdit")
    public String updateProfileForm(Model model, Principal principal){
        model.addAttribute("user", userDetailsService.getUserByEmail(principal.getName()));
        return "profilePageEdit";
    }

    @PostMapping("/profileEdit")
    public String updateProfile(User user) {
        userDetailsService.saveUser(user);
        return "redirect:/profile/getProfilePage";
    }
}
