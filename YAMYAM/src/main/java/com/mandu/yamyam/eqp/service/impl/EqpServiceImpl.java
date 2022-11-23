package com.mandu.yamyam.eqp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.eqp.mapper.EqpMapper;
import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;

@Service
public class EqpServiceImpl implements EqpService {
	@Autowired
	EqpMapper eqpMapper;
	
	// 설비 리스트 전체 조회
	@Override
	public List<EqpVO> getEqpList() {
		return eqpMapper.getEqpList();
	}
	
	// 설비 단건 조회
	@Override
	public EqpVO getEqp(EqpVO eqpVO) {
		return eqpMapper.getEqp(eqpVO);
	}
	
	// 설비 등록 및 수정
	@Override
	public int regAndUpdateEqp(EqpVO eqpVO) {
		int result = 0;
		
		// eqpCd 'empty'여부에 따라서 등록/수정 
		if (eqpVO.getEqpCd().equals("empty")) {
			// 등록
			result = eqpMapper.insertEqp(eqpVO);
		} else {
			result = eqpMapper.updateEqp(eqpVO);
		}
		
		return result;
	}

	// 설비업체 전체 조회
	@Override
	public List<EqpVO> getEqpActList() {
		return eqpMapper.getEqpActList();
	}

	// 설비가동여부 리스트 조회
	@Override
	public List<EqpVO> getEqpStsList() {
		return eqpMapper.getEqpStsList();
	}

	// 설비목록 모달 조회
	@Override
	public List<EqpVO> getEqpListModal() {
		return eqpMapper.getEqpListModal();
	}

	// 상세공통 설비구분 코드/명 조회
	@Override
	public List<EqpVO> getEqpTypeListModal() {
		return eqpMapper.getEqpTypeListModal();
	}

	// 설비 삭제
	@Override
	public int eqpDelete(List<EqpVO> list) {
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			result += eqpMapper.eqpDelete(list.get(i));
		}
		return result;
	}

}
