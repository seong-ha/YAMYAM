package com.mandu.yamyam.ord.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class OrdVO {
	
	// 주문서 테이블 B_OD
	private String odCd; 	// 주문코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date odDate; 	// 주문일자
	private int odAmt; 		// 주문량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deDate; 	// 납기일자
	private String odSts; 	// 진행상황구분 (진행, 완료)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pplnDate; 	// 계획등록일자
	private String planCd; 	// 생산계획코드
	private String prdCd; 	// 완제품코드
	private String actCd;	// 거래처코드
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;	// 시작날짜 (조회용)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;	// 종료날짜 (조회용)
	
	// 생산요청서 테이블 B_POD
	private String rqtNo;		// 요청번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rqtDate;	// 요청일자
	private int rqtAmt;		// 요청수량
	private String rqtSts; 	// 진행상황구분 (미계획, 계획완료)
	
	
	// 완제품 재고 테이블 B_IN
	private String prdLot;	// 완제품LOT
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date podDate;	// 생산일자
	private int binAmt;		// 입고수량
	private int samt;		// 재고수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edate;		// 유통기한
	private int agAmt;		// 폐기량
	private String podCd;	// 생산지시코드
	
	
	// 완제품 출고 테이블 B_OUT
	private String outNo;	// 출고번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bdates;	// 출고일자
	private int bamt;		// 출고수량
	private String outEtc;  // 비고
	
	
	// 완제품 반품 테이블 B_RT
	private String reCd;	// 반품코드
	private int reAmt;		// 반품량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reDate;	// 반품일자
	
	
	// 참고 테이블
	private String prdNm;		// 완제품명
	private String actNm;		// 거래처명
	private String edate_Yn;	// 유통기한 경고표시
	private int prdSfamt;		// 안전 재고량
	private String prdSfamtSts; // 안전재고 경고표시
}
