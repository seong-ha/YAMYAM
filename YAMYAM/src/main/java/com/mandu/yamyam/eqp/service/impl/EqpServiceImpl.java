package com.mandu.yamyam.eqp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.eqp.mapper.EqpMapper;
import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;

@Service
public class EqpServiceImpl implements EqpService {
	@Autowired
	EqpMapper eqpMapper;
	
	@Override
	public List<EqpVO> getEqpList() {
		return eqpMapper.getEqpList();
	}
	
	@Override
	public int regAndUpdateEqp(EqpVO eqpVO) {
		
		return 0;
	}

	@Override
	public List<EmpVO> getEqpActList() {
		return eqpMapper.getEqpActList();
	}

}
