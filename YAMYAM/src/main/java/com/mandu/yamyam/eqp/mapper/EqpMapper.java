package com.mandu.yamyam.eqp.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.eqp.service.ChkVO;
import com.mandu.yamyam.eqp.service.EqpVO;
import com.mandu.yamyam.eqp.service.UopVO;

public interface EqpMapper {
	// 설비전체조회
	List<EqpVO> getEqpList();
	
	// 설비단건 조회
	EqpVO getEqp(EqpVO eqpVO);
	
	// 설비등록
	int insertEqp(EqpVO eqpVO);
	
	// 설비 수정
	int updateEqp(EqpVO eqpVO);
	
	// 설비업체 전체 조회
	List<EqpVO> getEqpActList();
	
	// 설비목록 모달 조회
	List<EqpVO> getEqpListModal();
	
	// 설비 삭제
	int eqpDelete(EqpVO eqpVO);
	
	// 비가동 리스트 조회(일주일치)
	List<UopVO> getUopList();
	
	// 비가동 리스트 조건 조회
	List<UopVO> findUopList(UopVO uopVO);
	
	// 비가동 등록
	int insertUop(UopVO uopVO);
	
	// 비가동 수정
	int updateUop(UopVO uopVO);
	
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
	int insertEqpChk(ChkVO chkVO);
	
	// 설비 점검 수정
	int updateEqpChk(ChkVO list);
	
	// 설비 점검 조건 조회
	List<ChkVO> findEqpChkList(ChkVO chkVO);
	
	// 설비 점검 삭제
	int deleteEqpChk(ChkVO chkVO);
}
