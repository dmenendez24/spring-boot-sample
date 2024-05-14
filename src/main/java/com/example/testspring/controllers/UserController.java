package com.example.testspring.controllers;

import com.example.testspring.models.UserModel;
import com.example.testspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> list() {
        return userService.getUsers();
    }

    @GetMapping("/me")
    public UserModel me() {
        return userService.getUsers().get(0);
    }

    @PostMapping
    public boolean create(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

}
