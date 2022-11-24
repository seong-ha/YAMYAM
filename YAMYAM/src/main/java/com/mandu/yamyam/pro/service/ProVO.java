package com.mandu.yamyam.pro.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data

public class ProVO {
	// 공통코드
	private String commdCd;	// 분류 코드
	private String commdNm;	// 분류 이름
	
	// 생산계획 테이블 P_PLN
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pplnDate; 		// 계획등록일자
	
	private String pplnCd;		// 생산계획코드
	private String odCd;		// 주문코드
	private String pplnName;	// 계획명
	private String pplnSts;		// 진행구분('자재팀확인','미지시','지시완료')
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate; 	// 조회시 시작일자
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; 		// 조회시 끝나는일자
	
	// 상세생산계획 테이블 P_PLND
	
	private String pplndCd;		// 상세생산계획코드
	private int pplndPrio;		// 작업우선순위
	private int pplndDays;		// 생산일수
	private String prdCd;		// 완제품코드
	private String prdNm;		// 완제품
	private int pplndAmt;		// 생산계획량
	
	// 생산지시 테이블 P_OD
	private String podCd;		// 생산지시코드
	private String podSts;		// 진행구분
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date podDates;		// 지시등록일자
	
	
	// 상세생산지시 테이블 P_ODD
	private String poddCd;		// 상세생산지시코드
	private int poddAmt;		// 작업지시량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date poddDates;		// 생산일자
	private int poddPrio;		// 지시우선순위
	
	// 생산공정 테이블 P_PRO eqp_nm, eqp_cd, md_nm
	private String pproCd;		// 공정코드
	private String eqpCd;		// 설비코드
	private String eqpNm;		// 설비이름
	private String eqpType; 	// 설비타입
	private String mdNm;		// 설비 모델이름
	private String pproName;	// 공정명
	private String pproEmpName; // 담당자
	private int pproInAmt;		// 투입량
	private int pproErAmt;		// 불량량
	private int pproOtAmt;		// 생산량
	private String pproSts;		// 공정구분
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date pproSTime;		// 공정시작시간
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date pproETime;		// 공정종료시간
	private String pproErCd;	// 불량코드
	private String pproErDtl;	// 불량내역
	
	// 생산라인 테이블 P_LINE
	private String plineCd;		// 라인코드
	private int plineNo;		// 순번(라인)
	
	// 생산요청 모달 그리드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date deDate;	// 납기일자
	private int odAmt;		// 생산요청 수량
	
	
	// 자재 입고 테이블(자재 재고 변경)
	private String mtrCd;	// 자재코드
	private String mtrNm;	// 자재이름
	private int matOutAmt;	// 자재 출고 수량
	private String matLot;	// 자재LOT
}
