package com.mandu.yamyam.comm.service;

import java.util.List;

public interface CommService {
	
	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();
	
	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO);
		
}
