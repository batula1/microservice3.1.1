package com.java.springboot.web.web.controller;

import com.java.springboot.web.web.model.User;
import com.java.springboot.web.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService serviceUser;

    @Autowired
    public UserController(UserService serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        model.addAttribute("users", serviceUser.getUsers());
        return "listUsers";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        model.addAttribute("users", new User());
        return "userInfo";

    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("users") User users) {
        serviceUser.saveUser(users);
        return "redirect:/";
    }

    @GetMapping("/updateInfo")
    public String updateUserForm(@RequestParam("id") int id, Model model) {
        User user = serviceUser.getUser(id);
        model.addAttribute("id", id);
        if (user != null) {
            model.addAttribute("user", user);
            return "updateUser";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User updatedUser, int id) {
        User user = serviceUser.getUser(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setLastname(updatedUser.getLastname());
            user.setAge(updatedUser.getAge());
            serviceUser.updateUser(id, user);
        }
        return "redirect:/";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        serviceUser.deleteUser(id);
        return "redirect:/";
    }
}