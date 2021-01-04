package com.javabyexample.mybatis.controller;

import com.javabyexample.mybatis.mapper.IBlogMapper;
import com.javabyexample.mybatis.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogMapper dao;

    @GetMapping("/{id}")
    public ResponseEntity<Blog> selectBlogById(@PathVariable Integer id) {
        Optional<Blog> blog = dao.selectBlogById(id);
        return ResponseEntity.of(blog);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> selectBlogByAuthor(@RequestParam String author) {
        List<Blog> blog = dao.selectBlogByAuthor(author);
        return ResponseEntity.of(Optional.of(blog));
    }
}
