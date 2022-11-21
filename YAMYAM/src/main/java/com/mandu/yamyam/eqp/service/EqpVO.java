package com.mandu.yamyam.eqp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EqpVO {
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
}
