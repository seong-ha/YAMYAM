package com.mandu.yamyam.comm.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	
	// 직원
	private int empNo; // 직원 번호
	private String deptCd; // 부서코드
	private String deptNm; // 부서이름
	private String empNm; // 직원 이름
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date empDate; // 입사일
	private String empId; // 계정 아이디
	private String empPw; // 계정 비밀번호
	private String empPwcr; // 계정 비밀번호 확인
	private String empRole; // 직급 정보
}
