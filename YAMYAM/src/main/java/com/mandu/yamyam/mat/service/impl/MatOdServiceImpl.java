package com.mandu.yamyam.mat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.mat.mapper.MatOdMapper;
import com.mandu.yamyam.mat.service.MatOdService;
import com.mandu.yamyam.mat.service.MatOdVO;
import com.mandu.yamyam.mat.service.MatOddVO;

@Service
public class MatOdServiceImpl implements MatOdService {

	@Autowired
	MatOdMapper mapper;

	// 자재 목록 조회(일반 탭)
	@Override
	public List<MatOddVO> matList() {
		// TODO Auto-generated method stub
		return null;
	}

	// 업체 목록 조회(일반 탭)
	@Override
	public List<MatOddVO> actList() {
		// TODO Auto-generated method stub
		return null;
	}

	// 전체조회(일반 탭)
	@Override
	public List<Map<String, Object>> matOrderList() {
		return mapper.matOrderList();
	}

	@Override
	public MatOdVO matOrderFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map insertMatOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map deleteMatOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map getResult(int count, MatOdVO matVO) {
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("result", count);
		result.put("data", matVO);
		return result;
	}

}
