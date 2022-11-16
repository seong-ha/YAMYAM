package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatChkVO {
	private String mChkCd;		// 입고검수코드
	private String mOdCd;		// 발주코드
	private int paAmt;			// 합격량
	private int erAmt;			// 불합격량
	private int empNo;			// 담당자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mChkDate;		// 검사일자
	private String erCd;		// 불량코드
	private String erInfo;		// 불량내용
}
