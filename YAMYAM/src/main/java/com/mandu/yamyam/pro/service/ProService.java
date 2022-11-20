package com.mandu.yamyam.pro.service;

import java.util.List;


public interface ProService {
	// 상세생산계획조회
	public List<ProVO> planDetail();
	
	// 상세생산계획 수정 (작업우선순위, 생산일자)
	public int updatePlanDetail(ProVO vo);
	
	// 생산요청서 목록 조회
	public List<ProVO> orderList();
}
