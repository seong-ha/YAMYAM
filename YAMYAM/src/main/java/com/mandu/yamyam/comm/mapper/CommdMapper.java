package com.mandu.yamyam.comm.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.CommdVO;

public interface CommdMapper {

	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm();
	
	// ajax 공통코드 클릭시 상세 공통 코드 일치 하는 값 가져오기
	public List<CommdVO> ajaxSelectDetailCommClick();
		
}
