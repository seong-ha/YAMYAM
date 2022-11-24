package com.mandu.yamyam.eqp.service;

import java.util.List;

public interface EqpService {
	// 설비 리스트 전체 조회
	List<EqpVO> getEqpList();
	
	// 설비 단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 설비 등록 및 수정
	int regAndUpdateEqp(EqpVO eqpVO);
	
	// 설비업체 전체 조회
	List<EqpVO> getEqpActList();
	
	// 설비가동여부 리스트 조회
	List<EqpVO> getEqpStsList();

	// 설비목록 모달 조회
	List<EqpVO> getEqpListModal();
	
	// 상세공통 설비구분 코드/명 조회
	List<EqpVO> getEqpTypeListModal();
	
	// 설비 삭제
	int eqpDelete(List<EqpVO> list);
	
	// 비가동명 리스트 조회
	List<EqpVO> getUopTypeList();
}
