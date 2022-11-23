package com.mandu.yamyam.comm.service;

import java.util.List;

public interface CommdService {

	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm();
	
	// ajax 공통코드 클릭시 상세 공통 코드 일치 하는 값 가져오기
	public List<CommdVO> ajaxSelectDetailCommClick();
	
}
