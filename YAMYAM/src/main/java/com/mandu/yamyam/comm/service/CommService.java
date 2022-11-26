package com.mandu.yamyam.comm.service;

import java.util.List;

public interface CommService {
	
	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();

	
	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO);

	// ajax 상세 공통 코드 등록
	public int ajaxInsertDetailComm(List<CommdVO> commdVO); 
	
	// ajax 상세 공통 코드 삭제
	public int ajaxDeleteDetailComm(List<CommdVO> commdVO);
	
	// ajax 공통 코드 등록
	public int ajaxInsertComm(CommVO commVO);
	
	// 상세 공통 코드, 이름 불러오기(성하)
	public List<CommdVO> getCommdCdNm(String commCd);

	
	
	// ajax 자재 코드 불러오기
	public List<MtrVO> ajaxSelectMat();
	// ajax 자재탭 - 거래처 코드(모달) 불러오기
	public List<ActVO> ajaxSelectModalAct();
	// ajax 자재 - 자재 단건 정보 가져오기
	public MtrVO ajaxSelectMtrInfo(MtrVO mtrVO);
	
	
	// ajax 거래처 코드 불러오기
	public List<ActVO> ajaxSelectAct();
	
	
	// ajax 완제품 코드 불러오기
	public List<PrdVO> ajaxSelectPrd(PrdVO proVO);
	
	
	// ajax BOM 코드 불러오기
	public List<BOMVO> ajaxSelectBOM();
	// ajax BOM 제품목록(모달창)
	public List<PrdVO> ajaxSelectModalBOM();
	
}
