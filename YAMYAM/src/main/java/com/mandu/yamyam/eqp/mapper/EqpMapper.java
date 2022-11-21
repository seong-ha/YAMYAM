package com.mandu.yamyam.eqp.mapper;

import com.mandu.yamyam.eqp.service.EqpVO;

public interface EqpMapper {
	// 단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 등록
	int insertEqp(EqpVO eqpVO);
}
