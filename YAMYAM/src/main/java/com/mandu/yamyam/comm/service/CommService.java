package com.mandu.yamyam.comm.service;

import java.util.List;

public interface CommService {
	
	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();

	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO);

	// ajax 상세 공통 코드 등록
	public List<CommdVO> ajaxInsertDetailComm(List<CommdVO> commdVO); 
		
	// ajax 자재 코드 불러오기
	public List<MtrVO> ajaxSelectMat();
	
	// ajax 자재에 거래처검색(모달) 불러오기
	public List<ActVO> ajaxSelectAct();
	
	// ajax 완제품 코드 불러오기
	public List<PrdVO> ajaxSelectPrd();
	
	// ajax BOM 코드 불러오기
	public List<BOMVO> ajaxSelectBOM();
}
