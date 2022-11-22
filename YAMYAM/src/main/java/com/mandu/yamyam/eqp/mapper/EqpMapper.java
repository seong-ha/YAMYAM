package com.mandu.yamyam.eqp.mapper;

import java.util.List;

import com.mandu.yamyam.eqp.service.EqpVO;

public interface EqpMapper {
	// 설비전체조회
	List<EqpVO> getEqpList();
	
	// 설비단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 설비등록
	int insertEqp(EqpVO eqpVO);
	
	// 설비업체 전체 조회
	List<EqpVO> getEqpActList();
	
	// 설비가동여부 리스트 조회
	List<EqpVO> getEqpStsList();
	
	// 설비목록 모달 조회
	List<EqpVO> getEqpListModal();
	
	// 상세공통 설비구분 코드/명 조회
	List<EqpVO> getEqpTypeListModal();
	
	// 설비 삭제
	int eqpDelete(EqpVO eqpVO);
}
