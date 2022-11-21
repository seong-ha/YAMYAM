package com.mandu.yamyam.comm.service;

import lombok.Data;

@Data
public class BOMVO {

	// BOM
	private int bomNo; // 번호
	private String prdCd; // 완제품 코드
	private String bomCd; // BOM 코드
	private String mtrCd; // 자재 코드
	private String pproCd; // 공정코드
	private int bomAmt; // 소모량
	private String bomUse; // 사용 여부
}
