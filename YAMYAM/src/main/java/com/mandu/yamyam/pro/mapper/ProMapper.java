package com.mandu.yamyam.pro.mapper;

import java.util.List;
import java.util.Map;

import com.mandu.yamyam.pro.service.ProVO;

public interface ProMapper {
	// 입력될 생산 우선순위 조회
	public int getPrioNo();
	/*---------------
	// 생산 계획 관리(관리탭)
	----------------*/
	
	// 생산계획 조회
	public List<ProVO> getPlan(ProVO vo);
	
	// 상세생산계획조회
	public List<ProVO> getPlanDetail(ProVO vo);

	// 생산계획 등록
	public int insertPlan(ProVO vo);
	
	// 상세생산계획 등록
	public int insertPlanDetail(ProVO vo);

	
	// 상세생산계획 수정 (작업우선순위, 생산일자)
	public int updatePlanDetail(ProVO vo);
	
	// 상세생산계획 삭제
	public int deletePlanDetail(ProVO vo);
	
	// 생산계획 삭제
	public int deletePlan(ProVO vo);
	
	// 생산계획 상세 개수
	public int detailCnt(ProVO vo);
	
	/*---------------
	// 생산 계획 관리(등록탭)
	----------------*/
	
	// 생산요청서 목록 조회
	public List<Map<String,Object>> orderList();
	
	// 제품목록 조회
	public List<Map<String,Object>> materialList();
	
	/*---------------
	// 생산 지시 관리
	----------------*/
	// 미지시 계획 조회
	public List<ProVO> noOrderList();
	
	// 생산라인 조회
	public List<Map<String,Object>> lineList(ProVO vo);
	
	// 필요자재 조회
	public List<ProVO> needM(ProVO vo);
}
