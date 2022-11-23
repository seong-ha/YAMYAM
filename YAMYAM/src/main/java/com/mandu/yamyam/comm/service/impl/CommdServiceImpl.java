package com.mandu.yamyam.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.mapper.CommdMapper;
import com.mandu.yamyam.comm.service.CommdService;
import com.mandu.yamyam.comm.service.CommdVO;

@Service
public class CommdServiceImpl implements CommdService {
	
	@Autowired
	CommdMapper commdMapper;

	@Override
	public List<CommdVO> ajaxSelectDetailComm() {
		return commdMapper.ajaxSelectDetailComm();
	}

	@Override
	public List<CommdVO> ajaxSelectDetailCommClick() {
		// TODO Auto-generated method stub
		return null;
	}

}
