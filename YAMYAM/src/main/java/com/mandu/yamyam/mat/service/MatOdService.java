package com.mandu.yamyam.mat.service;

import java.util.List;
import java.util.Map;

public interface MatOdService {
	
	// 자재 목록 조회(일반 탭)
	public List<MatOddVO> matList();
	
	// 업체 목록 조회(일반 탭)
	public List<MatOddVO> actList();

	// 전체조회(일반 탭)
	public List<Map<String, Object>> matOrderList();
	
	// 조건조회(일반 탭)
	public MatOdVO matOrderFilter();
	
	// 추가(일반 탭)
	public Map insertMatOrder();
	
	// 삭제(일반 탭)
	public Map deleteMatOrder();
	
	// 신규 생산 계획 전체조회(생산계획서용 탭)
	
	// 필요 자재 전체조회(생산계획서용 탭)
	
	// 자재 발주 전체조회(생산계획서용 탭)
	
}
