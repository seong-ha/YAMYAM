package com.mandu.yamyam.pro.service;

import java.util.List;
import java.util.Map;


public interface ProService {
	// 입력될 생산 우선순위 조회
	public int getPrioNo();
	/*---------------
	// 생산 계획 관리(관리탭)
	----------------*/
	
	// 생산계획 조회
	public List<ProVO> getPlan(ProVO vo);
	
	// 상세생산계획조회
	public List<ProVO> planDetail(ProVO vo);
	
	
	// 상세생산계획 수정 (작업우선순위, 생산일자)
		public int updatePlanDetail(List<ProVO> vo);
		
	// 상세생산계획 삭제
	public int deletePlanDetail(List<ProVO> vo);
		
	
	/*---------------
	// 생산 계획 관리(등록탭)
	----------------*/
	// 생산요청서 목록 조회
	public List<Map<String,Object>> orderList();
	
	// 제품목록 조회
	public List<Map<String,Object>> materialList();
	
	// 생산계획 등록
	public int insertPlan(List<ProVO> vo);
	
		
	/*---------------
	// 생산 지시 관리
	----------------*/
	// 미지시 계획 조회
	public List<ProVO> noOrderList();
	
	// 생산라인 조회
	public List<Map<String,Object>> lineList(ProVO vo);
	
	// 필요자재 조회
	public List<ProVO> needM(ProVO vo);
	
	// 필요자재 lot 목록 조회
	public List<ProVO> mLotList(ProVO vo);
	
	// 생산지시 등록
	public int insertOrder(List<ProVO> vo);
		
}
