package com.mandu.yamyam.mat.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatVO {
	// 자재출고 테이블
	private int matOutNo;		// 자재출고번호
	private int matOutAmt;		// 출고수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOutDate;	// 출고일자
	private String matOutSts;	// 출고구분
	
	// 자재검수 테이블
	private String matChkCd;	// 입고검수코드
	private int paAmt;			// 합격량
	private int erAmt;			// 불합격량
	private String empNm;		// 담당자 이름
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matChkDate;	// 검사일자
	private String erCd;		// 불량코드
	private String erInfo;		// 불량내용
	
	// 자재반품 테이블
	private String matRtCd;		// 반품코드
	private int matRtAmt;		// 반품수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matRtDate;		// 반품요청일
	
	// 자재입고 테이블
	private String matLot;		// 자재LOT 
	private int matInAmt;		// 입고수량
	private int matSamt;		// 재고
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matEdate;		// 유통기한
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matInDate;		// 입고일
	
	// 자재발주 테이블
	private String matOdCd;		// 발주코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOdDd;		// 발주신청일
	private String matOdSts;	// 검수여부
	private int matSum;			// 총액
	
	// 자재발주상세 테이블
	private String matOddCd;	// 발주상세코드
	private int matOddMn;		// 단가
	private int matOddAmt;		// 발주량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date matOddDate;	// 납기요청일
	
	// 자재코드 테이블
	private String mtrCd;		// 자재코드
	private String mtrNm;		// 자재명
	private String mtrStd;		// 규격
	private String mattrUn;		// 작업단위
	private int mtrSfamt;		// 안잰재고수량
	private String mtrSts;		// 제품구분
	
	// 공통상세 테이블
	private String commdCd;		// 상세공통코드
	private String commCd;		// 공통코드
	private String commdNm;		// 상세 공통 이름
	private String commdInfo;	// 상세 공통 내용
	private String commdUse;	// 사용여부
	
	// BOM 테이블
	private int bomNo;			// 번호
	private String bomCd;		// BOM코드
	private String pproCd;		// 공정코드
	private int bomAmt;			// 소모량
	private String bomUse;		// 사용여부

	// 거래처코드 테이블
	private String actCd;		// 거래처코드
	private String actNm;		// 거래처업체명
	private String actNum;		// 사업자등록번호
	private String actTel;		// 전화번호
	private String actSts;		// 거래상태
	private String actDiv;		// 거래처구분
	
	// 완제품코드 테이블
	private String prdCd;		// 완제품코드
	private String prdNm;		// 완제품명
	private String prdStd;		// 규격
	private String prdUn;		// 단위
	private int prdSfamt;		// 안전재고수량
	
	// 생산요청서 테이블
	private int rqtNo;			// 주문코드
	private Date rqtDate;		// 요청일자
	private int rqtAmt;			// 요청수량
	private int rqtSts;			// 진행상황구분
	
	// 생산지시
	private String podCd;		// 생산지시코드
	private String plineCd;		// 라인코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date podDates;		// 지시등록일자
	
	// 상세생산지시
	private String poddCd;		// 상세생산지시코드
	private String poddSts;		// 진행구분
	private int poddAmt;		// 작업지시량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date poddDates;		// 생산일자
	private int poddPrio;		// 지시우선순위
	private String poddOther;	// 비고
	
	// 완제품 재고 테이블
	private String prdLot;		// 완제품Lot
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date podDate;		// 생산일자
	private int binAmt;			// 입고수량
	private int samt;			// 재고수량
	private int binSts;			// 진행상황구분
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date edate;			// 유통기한
	private int agAmt;			// 폐기량
	
	// 주문서 테이블
	private String odCd;		// 주문코드
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date odDate;		// 주문일자
	private int odAmt;			// 주문량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deDate;		// 납기일자
	private int odSts;			// 진행상황구분
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pplnDats;		// 계획등록일자
	private String planCd;		// 생산계획코드
	
	// 생산계획 테이블
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pplnDays;		// 계획등록일자
	private String pplnCd;		// 생산계획코드
	private String pplnName;	// 계획명
	private String pplnSts;		// 진행구분
	
	// 상세생산계획 테이블
	private String pplndCd;		// 상세생산계획코드
	private int pplndPrio;		// 작업우선순위
	private int pplndDays;		// 생산일수
	private int pplndAmt;		// 생산계획량
	
}
