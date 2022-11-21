package com.mandu.yamyam.mat.service;

import java.util.List;
import java.util.Map;

public interface MatOdService {
	
	// 돋보기 자재 목록 모달
	public List<Map<String, Object>> matList();
	
	// 돋보기 업체 목록 모달
	public List<Map<String, Object>> actList();
	
	// 자재 발주 관리 - 전체 조회(일반 탭)
	public List<Map<String, Object>> matOrderList();
	
	// 자재 발주 관리 - 발주코드 단 건 delete(일반 탭)
	public int delMatOd(MatVO vo);
	
	// 자재 발주 관리 - 발주코드 여러건 delete(일반 탭)
	public int delMatOdList(MatVO vo);
	
	// 자재 발주 관리 - 발주상세코드 insert(일반 탭)
	public int insMatOdList(MatVO vo);
	
	// 신규 생산계획 조회(생산계획서용 탭)
	public List<Map<String, Object>> newPlanList();
	
	// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
	public List<Map<String, Object>> addNewPlan();

	// 자재 발주 전체 리스트(생산계획서용 탭)
	public List<Map<String, Object>> odMatList();
	
	// 신규 발주 전체 리스트(생산계획서용 탭)
	public List<Map<String, Object>> newPlanInfo(MatVO vo);
	
	// 필요 자재 리스트(자재 발주 - 생산계획 탭)
	public List<Map<String, Object>> needMatList(MatVO vo);
	
	// 자재 발주 리스트(자재 발주 - 생산계획 탭)
	public List<Map<String, Object>> chkMatList(MatVO vo);
	
	// 발주 신청일 조회 버튼 클릭 이벤트 (자재 발주 조회 - 조건 조회 탭)
	public List<Map<String, Object>> odListSearch(MatVO vo);
	
	// 자재 입고 검수 관리 - 추가 모달창
	public List<Map<String, Object>> addChkModal();
	
}
