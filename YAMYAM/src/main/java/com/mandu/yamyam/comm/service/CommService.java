package com.mandu.yamyam.comm.service;

import java.util.List;
import java.util.Map;

import com.mandu.yamyam.common.GridData;
import com.mandu.yamyam.pro.service.ProVO;

public interface CommService {
	
	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();
	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO);
	// ajax 상세 공통 코드 한건 불러오기
	public CommdVO ajaxFindCommd(CommdVO commdVO);
	// ajax 상세 공통 코드(등록, 수정, 삭제)
	Map<String, Object> ajaxModifiedCommd(GridData<CommdVO> gridData);
	// ajax 상세 공통 코드 등록
	public int ajaxInsertDetailComm(List<CommdVO> commdVO);
	// ajax 상세 공통 코드 수정	
	public int ajaxUpdateCommd(List<CommdVO> commdVO);
	// ajax 상세 공통 코드 삭제
	public int ajaxDeleteDetailComm(List<CommdVO> commdVO);
	// ajax 공통 코드 등록
	public int ajaxInsertComm(CommVO commVO);
	// 상세 공통 코드, 이름 불러오기(성하)
	public List<CommdVO> getCommdCdNm(String commCd);
	// ajax 공통 코드 단건 조회
	CommVO ajaxFindComm(String commCd);
	// ajax 공통 코드 수정
	int ajaxUpdateComm(CommVO commVO);
	// ajax 공통 코드 삭제
	int ajaxDeleteComm(CommVO commVO);

	
	// ajax 자재 코드 불러오기
	public List<MtrVO> ajaxSelectMat();
	// ajax 자재탭 - 거래처 코드(모달) 불러오기
	public List<ActVO> ajaxSelectModalAct();
	// ajax 자재 - 자재 단건 정보 가져오기
	public MtrVO ajaxSelectMtrInfo(MtrVO mtrVO);
	// ajax 자재 - 자재 정보 등록하기
	public int ajaxInsertMtr(MtrVO mtrVO);
	// ajax 자재 - 자재 정보 수정하기
	public int ajaxUpdateMtr(MtrVO mtrVO);
	// ajax 자재 - 자재 정보 삭제하기
	public int ajaxDeleteMtr(List<MtrVO> mtrVO);
	
	
	// ajax 거래처 코드 불러오기
	public List<ActVO> ajaxSelectAct();
	// ajax 구매 거래처 등록하기
	public int ajaxInsertAct(ActVO actVO);
	// ajax 구매 거래처 수정하기
	public int ajaxUpdateAct(ActVO actVO);
	// ajax 거래처 삭제하기
	public int ajaxDeleteAct(ActVO actVO);
	
	
	// ajax 완제품 코드 불러오기
	public List<PrdVO> ajaxSelectPrd(PrdVO proVO);
	// ajax 완제품 코드 등록하기
	public int ajaxInsertPrd(PrdVO prdVO);
	// ajax 완제품 코드 삭제하기
	public int ajaxDeletePrd(List<PrdVO> prdVO);
	
	
	// ajax BOM 코드 불러오기
	public List<BOMVO> ajaxSelectBOM();
	// ajax BOM 제품목록(모달창(grid2))
	public List<PrdVO> ajaxSelectModalBOM();
	// ajax BOM 사용공정명(모달창(grid3))
	public List<ProVO> ajaxSelectProInfoModalBOM();
	// ajax BOM 사용공정명(모달창(grid4))
	public List<PrdVO> ajaxSelectPrdInfoModalBOM();
	// ajax BOM 사용공정명(모달창(grid5))
	public List<MtrVO> ajaxSelectMtrInfoModalBOM();
	// ajax 상세 공통 코드(등록, 수정, 삭제)
	Map<String, Object> ajaxModifiedBOM(GridData<BOMVO> gridData);
	// ajax BOM 등록하기
	public int ajaxInsertBOM(List<BOMVO> bomVO);
	// ajax BOM 수정하기
	public int ajaxUpdateBOM(List<BOMVO> bomVO);
	// ajax BOM 삭제하기
	public int ajaxDeleteBOM(List<BOMVO> bomVO);
	// ajax BOM filter
	public List<BOMVO> ajaxFilterBOM(BOMVO bomVO);
}
