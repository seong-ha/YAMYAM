package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatRtVO {
	private String mRtCo;		// 반품코드
	private String mChkCd;		// 입고검수코드
	private String mtrCd;		// 자재코드
	private String actCd;		// 거래처코드
	private int mRtAmt;			// 반품수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mRtDate;		// 반품요청일
}
