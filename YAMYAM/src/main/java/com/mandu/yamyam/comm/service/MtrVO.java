package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class MtrVO {
	
	// 자재
	private String mtrCd; // 자재 코드
	private String actCd; // 거래처 코드
	private String actNm; // 거래처 코드
	private String mtrNm; // 자재명
	private String mtrStd; // 규격
	private String mtrUn; // 작업단위
	private int mtrSfamt; // 안전 재고 수량
	private int mtrPrc; // 단가
	private String mtrSts; // 제품 구분
}
