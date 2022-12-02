package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class ActVO {
	
	// 거래처
	private String actCd; // 거래처 코드
	private String actNm; // 거래처 업체명
	private String actNum; // 사업자 등록번호
	private String actTel; // 전화번호
	private String actSts; // 거래 상태
	private String actDiv; // 거래처 구분
	
	private String actDivNm; // 거래처 구분이름
	
	// 프로시저 결과값
	private int result;
}
