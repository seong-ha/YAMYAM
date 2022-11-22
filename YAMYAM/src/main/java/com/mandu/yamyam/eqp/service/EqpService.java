package com.mandu.yamyam.eqp.service;

import java.util.List;

import com.mandu.yamyam.emp.service.EmpVO;

public interface EqpService {
	// 설비 리스트 전체 조회
	List<EqpVO> getEqpList();
	
	// 설비 등록 및 수정
	int regAndUpdateEqp(EqpVO eqpVO);
	
	// 설비업체 전체 조회
	List<EmpVO> getEqpActList();
}
