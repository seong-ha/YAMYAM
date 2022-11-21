package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class PrdVO {
	
	// 완제품
	private String prdCd; // 완제품 코드
	private String prdNm; // 완제품 명
	private String prdStd; // 규격
	private String prdUn; // 단위
	private int prdSfamt; // 안전 재고 수량
}
