package com.javabyexample.mybatis.mapper;

import com.javabyexample.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IBlogMapper {
    Optional<Blog> selectBlogById(Integer id);
    List<Blog> selectBlogByAuthor(String author);
}
