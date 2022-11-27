package com.mandu.yamyam.comm.mapper;

import java.util.List;

import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.DeptVO;
import com.mandu.yamyam.comm.service.EmpVO;

public interface EmpMapper {
	
	/*
	 * employeeAD 서비스
	 */
	
	// ajax 데이터 불러오기
	public List<EmpVO> ajaxSelectAllEmp();
	
	
	// 직원 전체조회
	public List<CommVO> selectAllEmp();
	// 직원 정보 등록
	public int inserEmpInfo(EmpVO empVO);
	// 직원 정보 수정
	public int updateEmpInfo(EmpVO empVO);
	// 직원 정보 삭제
	public int deleteEmpInfo(EmpVO empVO);
	// 직원 정보 조회
	public EmpVO selectEmpInfo(String id);
	
	
	// 부서 조회(modal)
	public List<DeptVO> selectDept();
	// 상세 공통조회(modaL)
	public List<CommdVO> selectCommCode(String cd);
	
	
	
	
}
