package com.mandu.yamyam.pro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.pro.mapper.ProMapper;
import com.mandu.yamyam.pro.service.ProService;
import com.mandu.yamyam.pro.service.ProVO;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	ProMapper mapper;
	
	// 생산계획 조회
	@Override
	public List<ProVO> getPlan(ProVO vo) {
		return mapper.getPlan(vo);
	}
	
	// 상세생산계획 조회
	@Override
	public List<ProVO> planDetail(ProVO vo) {
		return mapper.getPlanDetail(vo);
	}
	
	// 생산계획 등록
	@Override
	public int insertPlan(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += mapper.insertPlan(vo.get(i));
		}
		return result;
	}
	
	// 상세생산계획 수정(작업우선순위, 생산일자)
	@Override
	public int updatePlanDetail(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			mapper.updatePlanDetail(vo.get(i));
		}
		return result;
	}
	
	
	// 생산계획 삭제
	@Override
	public int deletePlanDetail(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			mapper.deletePlanDetail(vo.get(i));
		}
		// detail건수 조회시 0이면 master 삭제
		int cnt = mapper.detailCnt(vo.get(0));
		if(cnt == 0) {
			mapper.deletePlan(vo.get(0));
		}
		return result;
	}
	
	
	// 생산요청서 모달 그리드 조회
	@Override
	public List<Map<String,Object>> orderList() {
		return mapper.orderList();
	}

	// 제품목록 조회
	@Override
	public List<Map<String,Object>> materialList() {
		return mapper.materialList();
	}
	
	// 입력될 생산 우선순위 조회
	@Override
	public int getPrioNo() {
		return mapper.getPrioNo();
	}
	

}
