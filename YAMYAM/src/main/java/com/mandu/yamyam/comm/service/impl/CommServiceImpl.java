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
	public List<CommdVO> ajaxInsertDetailComm(List<CommdVO> commdVO) {
		return null;
	}

	// ajax 자재코드 불러오기
	@Override
	public List<MtrVO> ajaxSelectMat() {
		return commMapper.ajaxSelectMat();
	}

	// ajax 자재에 거래처검색(모달) 불러오기
	@Override
	public List<ActVO> ajaxSelectAct() {
		return commMapper.ajaxSelectAct();
	}

	
	// ajax 완제품 코드 불러오기
	@Override
	public List<PrdVO> ajaxSelectPrd() {
		return commMapper.ajaxSelectPrd();
	}
	
	// ajax BOM 코드 불러오기
	@Override
	public List<BOMVO> ajaxSelectBOM() {
		return commMapper.ajaxSelectBOM();
	}
	
}
