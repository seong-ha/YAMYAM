package com.mandu.yamyam.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.mapper.EmpMapper;
import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.DeptVO;
import com.mandu.yamyam.comm.service.EmpService;
import com.mandu.yamyam.comm.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpMapper empMapper;
	
	// ajax 데이터 불러오기
	@Override
	public List<EmpVO> ajaxSelectAllEmp() {
		return empMapper.ajaxSelectAllEmp();
	}
	
	// 전체 조회
	@Override
	public List<CommVO> selectAllEmp() {
		return empMapper.selectAllEmp();
	}
	
	// 회원 등록(모달)
	@Override
	public int inserEmpInfo(EmpVO empVO) {
		// 비밀번호 Bcrypt 암호화
		BCryptPasswordEncoder bcrt = new BCryptPasswordEncoder();
		String bcryptPw = bcrt.encode(empVO.getEmpPw());
		empVO.setEmpPw(bcryptPw);
		
		return empMapper.inserEmpInfo(empVO);
	}
	
	// 회원 수정(모달)
	@Override
	public int updateEmpInfo(EmpVO empVO) {
		// 비밀번호 Bcrypt 암호화
		BCryptPasswordEncoder bcrt = new BCryptPasswordEncoder();
		String bcryptPw = bcrt.encode(empVO.getEmpPw());
		empVO.setEmpPw(bcryptPw);
		
		return empMapper.updateEmpInfo(empVO);
	}
	
	// 회원 삭제(모달)
	@Override
	public int deleteEmpInfo(List<EmpVO> empVO) {
		int result = 0;
		
		for (int i = 0; i < empVO.size(); i++) {
			result += empMapper.deleteEmpInfo(empVO.get(i));
		}
		
		return result;
	}
	
	// 회원 등록 부서(modal)
	@Override
	public List<DeptVO> selectDept() {
		return empMapper.selectDept();
	}
	
	// 회원 등록 직급정보(modaL)
	@Override
	public List<CommdVO> selectCommCode(String cd) {
		return empMapper.selectCommCode(cd);
	}
	
	// 직원 정보 조회
	@Override
	public EmpVO selectEmpInfo(String id) {
		return empMapper.selectEmpInfo(id);
	}

}
