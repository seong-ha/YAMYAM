package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOddVO {
	private String mOddCd;		// 발주상세코드
	private String mOdCd;		// 발주코드
	private String mCd;			// 자재코드
	private String actCd;		// 거래처코드
	private int mOddMn;			// 단가
	private int mOddAmt;		// 발주량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mOddDate;		// 납기요청일
}
