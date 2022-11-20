package com.mandu.yamyam.pro.mapper;

import java.util.List;

import com.mandu.yamyam.pro.service.ProVO;

public interface ProMapper {
	// 상세생산계획조회
	public List<ProVO> getPlanDetail();

	// 상세생산계획 수정 (작업우선순위, 생산일자)
	public int updatePlanDetail(ProVO vo);
	
	// 생산요청서 목록 조회
	public List<ProVO> orderList();
}
