package com.mandu.yamyam.comm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.mapper.CommMapper;
import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.DeptVO;
import com.mandu.yamyam.comm.service.EmpVO;

@Service
public class CommServiceImpl implements CommService{

	@Autowired
	CommMapper commMapper;
	
	// 전체 조회
	@Override
	public List<CommVO> selectAllEmp() {
		return commMapper.selectAllEmp();
	}
	
	// 회원 등록(모달)
	@Override
	public int inserEmpInfo(CommVO commonVO) {
		return commMapper.inserEmpInfo(commonVO);
	}
	
	// 회원 수정(모달)
	@Override
	public int updateEmpInfo(CommVO commonVO) {
		return commMapper.updateEmpInfo(commonVO);
	}
	
	// 회원 삭제(모달)
	@Override
	public int deleteEmpInfo(CommVO commonVO) {
		return commMapper.deleteEmpInfo(commonVO);
	}
	
	// 회원 등록 부서(modal)
	@Override
	public List<DeptVO> selectDept() {
		return commMapper.selectDept();
	}
	
	// 회원 등록 직급정보(modaL)
	@Override
	public List<CommdVO> selectCommCode(String cd) {
		return commMapper.selectCommCode(cd);
	}
	
	// ajax 데이터 불러오기
	@Override
	public List<EmpVO> ajaxSelectAllEmp() {
		return commMapper.ajaxSelectAllEmp();
	}

}
