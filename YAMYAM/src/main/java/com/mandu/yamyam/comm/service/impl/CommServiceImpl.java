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

	// ajax 완제품 코드 불러오기
	@Override
	public List<PrdVO> ajaxSelectPrd(PrdVO prdVO) {
		return commMapper.ajaxSelectPrd(prdVO);
	}
	
	// ajax BOM 코드 불러오기
	@Override
	public List<BOMVO> ajaxSelectBOM() {
		return commMapper.ajaxSelectBOM();
	}

	// ajax BOM 제품목록(모달) 불러오기
	@Override
	public List<PrdVO> ajaxSelectModalBOM() {
		return commMapper.ajaxSelectModalBOM();
	}
	

	
}
