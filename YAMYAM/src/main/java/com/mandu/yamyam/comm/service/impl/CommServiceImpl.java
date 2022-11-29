package com.mandu.yamyam.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.mapper.CommMapper;
import com.mandu.yamyam.comm.service.ActVO;
import com.mandu.yamyam.comm.service.BOMVO;
import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.MtrVO;
import com.mandu.yamyam.comm.service.PrdVO;
import com.mandu.yamyam.pro.service.ProVO;

@Service
public class CommServiceImpl implements CommService {
	
	@Autowired
	CommMapper commMapper;
	
	
	// ajax 공통코드 불러오기
	@Override
	public List<CommVO> ajaxSelectComm() {
		return commMapper.ajaxSelectComm();
	}

	// ajax 상세 공통 코드 불러오기
	@Override
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO) {
		return commMapper.ajaxSelectDetailComm(commdVO);
	}
	
	
	// ajax 상세 공통 코드 등록
	@Override
	public int ajaxInsertDetailComm(List<CommdVO> commdVO) {
		int result = 0;
		for(int i=0; i<commdVO.size(); i++) {
			result += commMapper.ajaxInsertDetailComm(commdVO.get(i));
		}
		return result;
	}
	
	// 상세 공통 코드 삭제
	@Override
	public int ajaxDeleteDetailComm(List<CommdVO> commdVO) {
		int result = 0;
		for(int i=0; i<commdVO.size(); i++) {
			result += commMapper.ajaxDeleteDetailComm(commdVO.get(i));
		}
		return result;
	}
	
	// ajax 공통 코드 등록
	@Override
	public int ajaxInsertComm(CommVO commVO) {
		return commMapper.ajaxInsertComm(commVO);
	}
	
	// 상세 공통 코드, 이름 불러오기(성하)
	@Override
	public List<CommdVO> getCommdCdNm(String commCd) {
		return commMapper.getCommdCdNm(commCd);
	}

	// ajax 공통 코드 단건 조회
	@Override
	public CommVO ajaxFindComm(String commCd) {
		return commMapper.ajaxFindComm(commCd);
	}

	// ajax 공통 코드 수정
	@Override
	public int ajaxUpdateComm(CommVO commVO) {
		return commMapper.ajaxUpdateComm(commVO);
	}

	// ajax 공통 코드 삭제
	@Override
	public int ajaxDeleteComm(CommVO commVO) {
		commMapper.ajaxDeleteComm(commVO);
		return commVO.getResult();
	}
	
	// ajax 자재코드 불러오기
	@Override
	public List<MtrVO> ajaxSelectMat() {
		return commMapper.ajaxSelectMat();
	}
	
	// 자재 - 거래처검색(모달) 불러오기
	@Override
	public List<ActVO> ajaxSelectModalAct() {
		return commMapper.ajaxSelectModalAct();
	}
	
	// ajax 자재 - 자재 단건 정보 가져오기
	@Override
	public MtrVO ajaxSelectMtrInfo(MtrVO mtrVO) {
		return commMapper.ajaxSelectMtrInfo(mtrVO);
	}
	
	// ajax 자재 - 자재 정보 등록하기
	@Override
	public int ajaxInsertMtr(MtrVO mtrVO) {
		return commMapper.ajaxInsertMtr(mtrVO);
	}
	
	// 자재 - 자재 정보 수정하기
	@Override
	public int ajaxUpdateMtr(MtrVO mtrVO) {
		int result = 0;
		result = commMapper.ajaxUpdateMtr(mtrVO);
		
		return result;
	}
	
	// 자재 - 자재 정보 삭제하기
	@Override
	public int ajaxDeleteMtr(List<MtrVO> mtrVO) {
		int result = 0;
		for (int i = 0; i < mtrVO.size(); i++) {
			result += commMapper.ajaxDeleteMtr(mtrVO.get(i)); 
		}
		return result;
	}

	// ajax 거래처 코드 불러오기
	@Override
	public List<ActVO> ajaxSelectAct() {
		return commMapper.ajaxSelectAct();
	}
	
	// 구매 거래처 등록하기
	@Override
	public int ajaxInsertAct(ActVO actVO) {
		return commMapper.ajaxInsertAct(actVO);
	}
	
	// ajax 구매 거래처 수정하기
	@Override
	public int ajaxUpdateAct(ActVO actVO) {
		return commMapper.ajaxUpdateAct(actVO);
	}

	// ajax 완제품 코드 불러오기
	@Override
	public List<PrdVO> ajaxSelectPrd(PrdVO prdVO) {
		return commMapper.ajaxSelectPrd(prdVO);
	}
	
	// ajax 완제품 등록하기
	@Override
	public int ajaxInsertPrd(PrdVO prdVO) {
		return commMapper.ajaxInsertPrd(prdVO);
	}
	
	// ajax 완제품 삭제하기
	@Override
	public int ajaxDeletePrd(List<PrdVO> prdVO) {
		int result = 0;
		for(int i = 0; i < prdVO.size(); i++) {
			result += commMapper.ajaxDeletePrd(prdVO.get(i));
		}
		return result;
	}
	
	// ajax BOM 코드 불러오기
	@Override
	public List<BOMVO> ajaxSelectBOM() {
		return commMapper.ajaxSelectBOM();
	}

	// ajax BOM 제품목록(모달(grid2) 불러오기
	@Override
	public List<PrdVO> ajaxSelectModalBOM() {
		return commMapper.ajaxSelectModalBOM();
	}

	// ajax BOM 공정명(모달(grid3) 불러오기
	@Override
	public List<ProVO> ajaxSelectProInfoModalBOM() {
		return commMapper.ajaxSelectProInfoModalBOM();
	}
	
	// ajax BOM 제품명(모달(grid4) 불러오기
	@Override
	public List<PrdVO> ajaxSelectPrdInfoModalBOM() {
		return commMapper.ajaxSelectPrdInfoModalBOM();
	}
	
	// ajax BOM 자재코드, 자재명(모달(grid5) 불러오기
	@Override
	public List<MtrVO> ajaxSelectMtrInfoModalBOM() {
		return commMapper.ajaxSelectMtrInfoModalBOM();
	}

	// ajax BOM 등록하기
	@Override
	public int ajaxInsertBOM(List<BOMVO> bomVO) {
		int result = 0;
		for(int i=0; i<bomVO.size(); i++) {
			result += commMapper.ajaxInsertBOM(bomVO.get(i));
		}
		return result;
	}

	// ajax BOM 삭제하기
	@Override
	public int ajaxDeleteBOM(List<BOMVO> bomVO) {
		int result = 0;
		for(int i=0; i < bomVO.size(); i++) {
			result += commMapper.ajaxDeleteBOM(bomVO.get(i));
		}
		return result;
	}
	
	

}
