package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class CommVO {
	
	// 공통 코드
	private String commCd; // 공통 코드
	private String commNm; // 공통 코드 이름
	private String commInfo; // 공통 코드 내용
	private String commUse; // 사용 여부

	// 프로시저 결과값
	private int result;
}
