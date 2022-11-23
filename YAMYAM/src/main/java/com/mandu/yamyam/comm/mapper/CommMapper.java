package com.mandu.yamyam.comm.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;

public interface CommMapper {

	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();
	
	// ajax 상세 공통 코드 불러오기
	public List<CommdVO> ajaxSelectDetailComm(CommdVO commdVO);
		
}
