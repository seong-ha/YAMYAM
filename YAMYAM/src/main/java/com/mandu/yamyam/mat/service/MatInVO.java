package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatInVO {
	private String mLot;	// 자재LOT
	private String mtrCd;	// 자재코드
	private String actCd;	// 거래처코드
	private int inAmt;		// 입고수량
	private int sAmt;		// 재고
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edate; 	// 유통기한
}
