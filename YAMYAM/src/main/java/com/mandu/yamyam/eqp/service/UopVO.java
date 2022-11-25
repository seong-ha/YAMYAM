package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Date uopStime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date uopEtime;
	private int result;
}
