package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class CommdVO {

	// 상세 공통 코드
	private String commdCd; // 상세 공통 코드
	private String commCd; // 공통 코드
	private String commdNm; // 상세 공통 이름
	private String commdInfo; // 상세 공통 내용
	private String commdUse; // 사용 여부
}
