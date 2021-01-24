package com.javabyexample.authub.controller;

import com.javabyexample.authub.entity.Authority;
import com.javabyexample.authub.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authority")
public class AuthorityController {
    @Autowired
    AuthorityMapper dao;

    @GetMapping("/{username}")
    public ResponseEntity<List<Authority>> selectAuthorityByUsername(@PathVariable String username) {
        List<Authority> authorities = dao.selectAuthorityByUsername(username);
        System.out.println(authorities);
        return ResponseEntity.of(Optional.of(authorities));
    }
}
