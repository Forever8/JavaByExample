package com.javabyexample.authub.mapper;

import com.javabyexample.authub.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorityMapper {
    List<Authority> selectAuthorityByUsername(String username);
}
