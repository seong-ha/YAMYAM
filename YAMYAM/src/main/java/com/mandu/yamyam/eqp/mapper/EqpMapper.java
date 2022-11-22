package com.mandu.yamyam.eqp.mapper;

import java.util.List;

import com.mandu.yamyam.emp.service.EmpVO;
import com.mandu.yamyam.eqp.service.EqpVO;

public interface EqpMapper {
	// 설비전체조회
	List<EqpVO> getEqpList();
	
	// 설비단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 설비등록
	int insertEqp(EqpVO eqpVO);
	
	
	// 설비업체 전체 조회
	List<EmpVO> getEqpActList();
}
