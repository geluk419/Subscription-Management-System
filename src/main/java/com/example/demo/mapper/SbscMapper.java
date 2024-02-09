package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.SbscVO;

@Mapper
public interface SbscMapper {
	// 조회
    SbscVO getSrvcInfo(String mbrId);
    
    // 기간연장
    int extendExpryYmd(String mbrId);

    // 구독
    int subscribeService(SbscVO sbscVo);
}