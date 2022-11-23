package com.mandu.yamyam.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.mapper.CommMapper;
import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.CommVO;

@Service
public class CommServiceImpl implements CommService {
	
	@Autowired
	CommMapper commMapper;

	
	@Override
	public List<CommVO> ajaxSelectComm() {
		return commMapper.ajaxSelectComm();
	}
	
}
