package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SbscService;
import com.example.demo.vo.SbscVO;
import com.example.demo.vo.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SbscController {

    private final SbscService sbscService;
    
    @GetMapping("/getSrvcInfo")
    public SbscVO getSrvcInfo(Authentication authentication) {
    	UserVO userVo = (UserVO) authentication.getPrincipal();
    	log.info("userVo : "+userVo);
    	String mbrId = userVo.getMbrId();
    	return sbscService.getSrvcInfo(mbrId);
    }
    
    @PutMapping("/extendExpryYmd")
    public int extendExpryYmd(Authentication authentication) {
    	UserVO userVo = (UserVO) authentication.getPrincipal();  
    	String mbrId = userVo.getMbrId();
    	return sbscService.extendExpryYmd(mbrId);
    }
    
    @PostMapping("/subscribeService")
    public int subscribeService(SbscVO sbscVo,Authentication authentication) {
    	UserVO userVo = (UserVO) authentication.getPrincipal();  
    	String mbrId = userVo.getMbrId();
    	sbscVo.setMbrId(mbrId);
    	return sbscService.subscribeService(sbscVo);
    }
}