package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.SbscMapper;
import com.example.demo.vo.SbscVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SbscService{
    private final SbscMapper sbscMapper;

    public SbscVO getSrvcInfo(String mbrId) {
    	return sbscMapper.getSrvcInfo(mbrId);
    }
    
    public int extendExpryYmd(String mbrId) {
    	return sbscMapper.extendExpryYmd(mbrId);
    }
    
    public int subscribeService(SbscVO sbscVo) {
    	return sbscMapper.subscribeService(sbscVo);
    }
}