package com.javabyexample.authub.mapper;

import com.javabyexample.authub.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> selectUserByUsername(String username);
}
