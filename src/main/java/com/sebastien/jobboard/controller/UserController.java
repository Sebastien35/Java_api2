package com.sebastien.jobboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.sebastien.jobboard.entity.User;
import com.sebastien.jobboard.service.UserService;
import com.sebastien.jobboard.repository.UserRepository;
import java.lang.Exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(path="/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        try {
            this.userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch(Exception e) {
            System.err.println("Error registering user:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
        }

    }
}
