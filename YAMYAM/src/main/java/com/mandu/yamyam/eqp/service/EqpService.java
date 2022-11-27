package com.mandu.yamyam.eqp.service;

import java.util.List;

import com.mandu.yamyam.comm.service.EmpVO;

public interface EqpService {
	// 설비 리스트 전체 조회
	List<EqpVO> getEqpList();
	
	// 설비 단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 설비 등록 및 수정
	int regAndUpdateEqp(EqpVO eqpVO);
	
	// 설비업체 전체 조회
	List<EqpVO> getEqpActList();
	
	// 설비목록 모달 조회
	List<EqpVO> getEqpListModal();
	
	// 설비 삭제
	int eqpDelete(List<EqpVO> list);
	
	// 비가동 리스트 조회(일주일치)
	List<UopVO> getUopList();
	
	// 비가동 리스트 조건 조회
	List<UopVO> findUopList(UopVO uopVO);
	
	// 비가동 등록 및 수정
	int insertUpdateUop(UopVO uopVO);
	
	// 비가동 삭제
	int deleteUop(String uopCd);
	
	// 비가동중인 설비 비가동 정보 가져오기
	UopVO getUop(String eqpCd);
	
	// 설비 점검 전체 조회(일주일치)
	List<ChkVO> getChkList();
	
	// 설비 직원 리스트 조회
	List<EmpVO> getEqpEmpList();
	
	// 점검 대상 설비 조회
	List<ChkVO> getEqpToChkList(int days);
	
	// 설비 점검 등록
	int insertEqpChk(List<ChkVO> list);
	
	// 설비 점검 수정
	int updateEqpChk(List<ChkVO> list);
	
	// 설비 점검 조건 조회
	List<ChkVO> findEqpChkList(ChkVO chkVO);
	
	// 설비 점검 삭제
	int deleteEqpChk(List<ChkVO> list);
}
