package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class eqpTotalVO {
	
	// 설비 테이블
	private String EqpCd;
	private String actCd;
	private String eqpNm;
	private String mdNm;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date mkDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date buyDate;
	private int chkCycle;
	private String eqpSts;
	private int uph;
	private String img;
	private String eqpType;
	private int highTemp;
	private int lowTemp;
	
	
	// 설비 비가동 테이블
	private int uopNo;
	private String uopNm;
	private String uopInfo;
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
	private Date uopStime;
	@DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
	private Date uopEtime;
	
	
	// 설비 점검 테이블
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date chkDate;
	private String chkRst;
	private String chkEmpNm;
	private String chkRecord;
	
	
	
}
