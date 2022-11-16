package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOdVO {
	private String mOdCd; 	// 발주코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mOdDd; 	// 발주신청일
	private String mOdSts;	// 검수여부
	private int mSum;		// 총액
}
