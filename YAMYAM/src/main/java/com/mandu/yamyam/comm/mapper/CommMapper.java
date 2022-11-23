package com.mandu.yamyam.comm.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.CommVO;

public interface CommMapper {

	// ajax 공통코드 불러오기
	public List<CommVO> ajaxSelectComm();
}
