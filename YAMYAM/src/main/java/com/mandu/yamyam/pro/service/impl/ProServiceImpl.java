package com.mandu.yamyam.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.pro.mapper.ProMapper;
import com.mandu.yamyam.pro.service.ProService;
import com.mandu.yamyam.pro.service.ProVO;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	ProMapper mapper;
	
	// 상세생산계획 조회
	@Override
	public List<ProVO> planDetail() {
		return mapper.getPlanDetail();
	}
	
	// 상세생산계획 수정(작업우선순위, 생산일자)
	@Override
	public int updatePlanDetail(ProVO vo) {
		return mapper.updatePlanDetail(vo);
	}

	// 생산요청서 모달 그리드 조회
	@Override
	public List<ProVO> orderList() {
		return mapper.orderList();
	}
}
