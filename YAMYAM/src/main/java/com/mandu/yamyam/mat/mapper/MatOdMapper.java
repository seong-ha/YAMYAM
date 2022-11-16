package com.mandu.yamyam.mat.mapper;

import java.util.List;
import java.util.Map;

import com.mandu.yamyam.mat.service.MatOdVO;

public interface MatOdMapper {
	
	// 자재 목록 조회(일반 탭)
	public Map<String, Object> matList();
	
	// 업체 목록 조회(일반 탭)
	public Map<String, Object> actList();

	// 전체조회(일반 탭)
	public List<Map<String, Object>> matOrderList();
	
	// 조건조회(일반 탭)
	public MatOdVO matOrderFilter();
	
	// 추가(일반 탭)
	public Map insertMatOrder(MatOdVO matVO);
	
	// 삭제(일반 탭)
	public Map deleteMatOrder(MatOdVO matVO);
	
	// 신규 생산 계획 전체조회(생산계획서용 탭)
	
	// 필요 자재 전체조회(생산계획서용 탭)
	
	// 자재 발주 전체조회(생산계획서용 탭)
}
