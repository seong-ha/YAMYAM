package com.mandu.yamyam.mat.mapper;

import java.util.List;
import java.util.Map;

import com.mandu.yamyam.mat.service.MatVO;

public interface MatOdMapper {
	//===============================================
	// 공통
	//===============================================
	// 돋보기 자재목록 모달
	public List<Map<String, Object>> matList();
	
	// 돋보기 업체목록 모달
	public List<Map<String, Object>> actList();
	
	
	
	//===============================================
	// 자재 발주 관리
	//===============================================
	// 자재 발주 관리(일반 탭)  - 전체 조회
	public List<Map<String, Object>> matOrderList();
	
	// 자재 발주 관리 - 발주상세코드 단건 delete(일반 탭)
	public int delMatOd(MatVO vo);
	
	// 자재 발주 관리 - 발주상세코드 여러건 delete(일반 탭)
	public int delMatOdList(MatVO vo);
	
	// 자재 발주 관리 - 발주상세코드 여러건 delete(일반 탭)
	public int delMatOddList(MatVO vo);
	
	// 자재 발주 관리 - 발주상세코드 insert(일반 탭)
	public int insMatOdList(MatVO vo);
	
	// 신규생산계획조회(생산계획서용 탭)
	public List<Map<String, Object>> newPlanList();
	
	// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
	public List<Map<String, Object>> addNewPlan();
	
	// 자재발주 전체리스트(생산계획서용 탭)
	public List<Map<String, Object>> odMatList();
	
	// 자재발주 전체리스트(생산계획서용 탭)
	public List<Map<String, Object>> newPlanInfo(String pplnCd);
	
	// 필요자재조회(생산계획 탭)
	public List<Map<String, Object>> needMatList(String prdCd);
	
	// 자재발주 리스트(생산계획 탭)
	public List<Map<String, Object>> chkMatList(String mtrCd);
	
	// 신규 생산 계획서 리스트 조회버튼(자재 발주 - 생산계획 탭)
	public List<Map<String, Object>> newPlanLookUpBtn(MatVO vo);
	
	//===============================================
	// 자재 발주 조회
	//===============================================
	// 발주 신청일 조회 버튼 클릭 이벤트 (자재 발주 조회 - 조건 조회 탭)
	public List<Map<String, Object>> odListSearch(MatVO vo);
	
	// 발주 신청일 클릭 시 이벤트 (조건 조회 탭)
	public List<Map<String, Object>> clickOdDate(MatVO vo);

	//===============================================
	// 자재 입고 검수 관리
	//===============================================
	// 자재 입고 검수 관리 - 추가 모달창
	public List<Map<String, Object>> addChkModal();
}
