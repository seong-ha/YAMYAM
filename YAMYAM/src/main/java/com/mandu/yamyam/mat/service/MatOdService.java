package com.mandu.yamyam.mat.service;

import java.util.List;
import java.util.Map;

public interface MatOdService {
	
	// 전체조회(일반 탭)
	public List<Map<String, Object>> matOrderList();
	
	// 돋보기 자재목록 모달
	public List<Map<String, Object>> matList();
	
	// 돋보기 업체목록 모달
	public List<Map<String, Object>> actList();
	
	// 필요자재조회(생산계획 탭)
	public List<Map<String, Object>> needMatList();
	
	// 신규생산계획조회(생산계획서용 탭)
	public List<Map<String, Object>> newPlanList();
	
	// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
	public List<Map<String, Object>> addNewPlan();

	// 자재발주 전체리스트(생산계획서용 탭)
	public List<Map<String, Object>> odMatList();
}
