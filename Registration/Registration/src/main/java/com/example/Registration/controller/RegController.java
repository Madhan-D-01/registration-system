package com.example.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Registration.model.User;
import com.example.Registration.service.RegService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RegController {

    @Autowired
    private RegService regService;

    @GetMapping("/h")
    public String hello() {
        return "Hello welcome!";
    }

    @GetMapping("/")
    public String home() {
        return "Registration System is Running Successfully!";
    }

    @PostMapping("/register")
    ResponseEntity<User> createregister(@RequestBody User user) {
        User create = regService.createUser(user);
        return new ResponseEntity<User>(create, HttpStatus.CREATED);
    }
}
