package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class SbscVO {
	private int infoNo;
	private int usgqty;
	private Date expryYmd;
	private int srvcNo;
	private int mbrNo;
	private String srvcTyp;
	private int useNmpr;
	private int strgCpcty;
	private String sbscPd;
	private int sbscChrge;
	
	private String mbrId;
}
