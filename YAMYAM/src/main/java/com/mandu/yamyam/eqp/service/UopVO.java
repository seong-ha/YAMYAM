package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UopVO {
	private String uopCd;
	private String eqpCd;
	private String eqpNm;
	private String uopType;
	private String uopTypeNm;
	private String uopInfo;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date uopStime;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date uopEtime;
	
	private int result;	// insert update 시 결과건수
	
	// 비가동 조회 시 시작끝날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
}
