package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.UserVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    String localTime = format.format(time);

    private final UserMapper userMapper;

    @Transactional
    public void joinUser(UserVO userVo){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVo.setPswd(passwordEncoder.encode(userVo.getPassword()));
        userVo.setAuthrt("USER");
        userMapper.saveUser(userVo);
    }

    @Override
    public UserVO loadUserByUsername(String mbrId) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        UserVO userVo = userMapper.getUserAccount(mbrId);
        if (userVo == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        return userVo;
    }
    
    public UserVO getUserAccount(String mbrId) {
    	return userMapper.getUserAccount(mbrId);
    }
}