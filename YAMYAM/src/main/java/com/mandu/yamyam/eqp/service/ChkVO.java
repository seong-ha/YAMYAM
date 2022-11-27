package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ChkVO {
	private String eqpCd;
	private String eqpNm;
	private String eqpType;
	private int chkCycle;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date chkDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date nextChkDate;	// 차기 점검일
	private String chkRst;
	private String chkRecord;
	private String chkEmp;
	private String chkEmpNm;
	
	// 설비 점김일 조건조회 시 시작끝날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
}
