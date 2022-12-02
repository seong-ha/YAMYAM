package com.mandu.yamyam.eqp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.eqp.mapper.EqpMapper;
import com.mandu.yamyam.eqp.service.ChkVO;
import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;
import com.mandu.yamyam.eqp.service.UopVO;

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

	// 설비목록 모달 조회
	@Override
	public List<EqpVO> getEqpListModal() {
		return eqpMapper.getEqpListModal();
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

	// 비가동 리스트 조회(일주일치)
	@Override
	public List<UopVO> getUopList() {
		return eqpMapper.getUopList();
	}

	// 비가동 등록 및 수정
	@Override
	public int insertUpdateUop(UopVO uopVO) {
		int insertResult = 0;
		int updateResult = 10;

		if (uopVO.getUopCd().equals("") || uopVO.getUopCd() == null) {
			eqpMapper.insertUop(uopVO);
			insertResult += uopVO.getResult();
			return insertResult;
		} else {
			eqpMapper.updateUop(uopVO);
			updateResult += uopVO.getResult();
			return	updateResult; 
		}
	}

	// 비가동 삭제
	@Override
	public int deleteUop(String uopCd) {
		return eqpMapper.deleteUop(uopCd);
	}

	// 비가동 리스트 조건 조회
	@Override
	public List<UopVO> findUopList(UopVO uopVO) {
		return eqpMapper.findUopList(uopVO);
	}

	// 비가동중인 설비 비가동 정보 가져오기
	@Override
	public UopVO getUop(String eqpCd) {
		return eqpMapper.getUop(eqpCd);
	}

	// 설비 점검 전체 조회(일주일치)
	@Override
	public List<ChkVO> getChkList() {
		return eqpMapper.getChkList();
	}

	// 설비 직원 리스트 조회
	@Override
	public List<EmpVO> getEqpEmpList() {
		return eqpMapper.getEqpEmpList();
	}

	// 점검 대상 설비 조회
	@Override
	public List<ChkVO> getEqpToChkList(int days) {
		return eqpMapper.getEqpToChkList(days);
	}

	// 설비 점검 등록
	@Override
	public int insertEqpChk(List<ChkVO> list) {
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			result += eqpMapper.insertEqpChk(list.get(i));
		}
		
		return result;
	}

	// 설비 점검 수정
	@Override
	public int updateEqpChk(List<ChkVO> list) {
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			result += eqpMapper.updateEqpChk(list.get(i));
		}
		
		return result;
	}

	// 설비 점검 조건 조회
	@Override
	public List<ChkVO> findEqpChkList(ChkVO chkVO) {
		return eqpMapper.findEqpChkList(chkVO);
	}

	// 설비 점검 삭제
	@Override
	public int deleteEqpChk(List<ChkVO> list) {
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) {
			result += eqpMapper.deleteEqpChk(list.get(i));
		}
		return result;
	}

}
