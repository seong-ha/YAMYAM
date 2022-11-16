package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatOutVO {
	private String mLot;		// 자재LOT
	private String podCd;		// 생산지시코드
	private String mtrCd;		// 출고수량
	private int mOutAmt;		// 출고일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mOutDate;		// 출고일자
	private String mOutSys;		// 출고구분
}
