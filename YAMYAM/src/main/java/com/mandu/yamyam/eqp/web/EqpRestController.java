package com.mandu.yamyam.eqp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.eqp.service.ChkVO;
import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;
import com.mandu.yamyam.eqp.service.UopVO;

@RestController
public class EqpRestController {
	@Autowired
	EqpService eqpService;
	@Autowired
	CommService commService;
	
	// 설비 리스트 전체 조회
	@GetMapping("/getEqpList")
	public List<EqpVO> getEqpList() {
		return eqpService.getEqpList();
	}

	// 설비목록 모달 조회
	@GetMapping("/getEqpListModal")
	public List<EqpVO> getEqpListModal() {
		return eqpService.getEqpListModal();
	}
	
	// 설비 단건 조회
	@PostMapping("/getEqp")
	public EqpVO getEqp(EqpVO eqpVO) {
		return eqpService.getEqp(eqpVO);
	}

	// 상세공통 설비구분 코드/명 조회
	@GetMapping("/eqpTypeListModal")
	public List<CommdVO> getEqpTypeListModal() {
		return  commService.getCommdCdNm("EQP-TYPE");
	}
	
	// 설비 삭제
	@PostMapping("/eqpDelete")
	public int eqpDelete(@RequestBody List<EqpVO> list) {
		return eqpService.eqpDelete(list);
	}
	
	// 비가동 리스트 조회(일주일치)
	@GetMapping("/getUopList")
	public List<UopVO> getUopList() {
		return eqpService.getUopList();
	}
	
	// 비가동 리스트 조건 조회
	@PostMapping("/findUopList")
	public List<UopVO> findUopList(UopVO uopVO) {
		return eqpService.findUopList(uopVO);
	}
	
	// 비가동 등록 및 수정
	@PostMapping("/insertUpdateUop")
	public int insertUpdateUop(UopVO uopVO) {
		System.out.println(uopVO.getUopEtime());
		return eqpService.insertUpdateUop(uopVO);
	}
	
	// 비가동 삭제
	@PostMapping("/deleteUop")
	public int deleteUop(String uopCd) {
		return eqpService.deleteUop(uopCd);
	}
	
	// 비가동중인 설비 비가동 정보 가져오기
	@PostMapping("/getUop")
	public UopVO getUop(String eqpCd) {
		return eqpService.getUop(eqpCd);
	}
	
	// 설비 점검 전체 조회(일주일치)
	@GetMapping("/getChkList")
	public List<ChkVO> getChkList() {
		return eqpService.getChkList();
	}
	
	// 설비 직원 리스트 조회
	@GetMapping("/getEqpEmpList")
	public List<EmpVO> getEqpEmpList() {
		return eqpService.getEqpEmpList();
	}
	
	// 점검 대상 설비 조회
	@PostMapping("/getEqpToChkList")
	public List<ChkVO> getEqpToChkList(int days) {
		return eqpService.getEqpToChkList(days);
	}
	
	// 설비 점검 등록
	@PostMapping("/insertEqpChk")
	public int insertEqpChk(@RequestBody List<ChkVO> list) {
		return eqpService.insertEqpChk(list);
	}
	
	// 설비 점검 수정
	@PostMapping("/updateEqpChk")
	public int updateEqpChk(@RequestBody List<ChkVO> list) {
		return eqpService.updateEqpChk(list);
	}
	
	// 설비 점검 조건 조회
	@PostMapping("/findEqpChkList")
	public List<ChkVO> findEqpChkList(ChkVO chkVO) {
		return eqpService.findEqpChkList(chkVO);
	}
	
	// 설비 점검 삭제
	@PostMapping("/deleteEqpChk")
	public int deleteEqpChk(@RequestBody List<ChkVO> list) {
		return eqpService.deleteEqpChk(list);
	}
}
