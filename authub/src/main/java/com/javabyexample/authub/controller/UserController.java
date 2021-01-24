package com.javabyexample.authub.controller;

import com.javabyexample.authub.entity.User;
import com.javabyexample.authub.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper dao;

    @GetMapping("/{username}")
    public ResponseEntity<User> selectUserByUsername(@PathVariable String username) {
        Optional<User> user = dao.selectUserByUsername(username);
        System.out.println(user);
        return ResponseEntity.of(user);
    }
}
