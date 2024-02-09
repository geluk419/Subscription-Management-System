package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.UserVO;

@Mapper
public interface UserMapper {
	// 로그인
    UserVO getUserAccount(String mbrId);

    // 회원가입
    void saveUser(UserVO userVo);
}