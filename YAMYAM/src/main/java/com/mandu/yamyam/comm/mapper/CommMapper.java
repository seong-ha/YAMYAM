package com.mandu.yamyam.comm.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.ActVO;
import com.mandu.yamyam.comm.service.BOMVO;
import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.MtrVO;
import com.mandu.yamyam.comm.service.PrdVO;

public interface CommMapper {

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
