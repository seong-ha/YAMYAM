package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EqpVO {
	private String eqpCd;
	private String actCd;
	private String actNm;
	private String eqpNm;
	private String mdNm;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date mkDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date buyDate;
	private int chkCycle;
	private String eqpSts;
	private int uph;
	private String img;
	private String eqpType;
	private int highTemp;
	private int lowTemp;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String chkDate;
	
	// 가동여부 상세공통
	private String commdCd;
	private String commdNm;
	
	// 설비구분 상세공통
	private String eqpTypeCd;
	private String eqpTypeNm;
}
