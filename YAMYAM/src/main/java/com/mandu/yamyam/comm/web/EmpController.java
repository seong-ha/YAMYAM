package com.mandu.yamyam.comm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mandu.yamyam.comm.service.ActVO;
import com.mandu.yamyam.comm.service.BOMVO;
import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.comm.service.CommVO;
import com.mandu.yamyam.comm.service.CommdVO;
import com.mandu.yamyam.comm.service.EmpService;
import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.comm.service.MtrVO;
import com.mandu.yamyam.comm.service.PrdVO;


@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	@Autowired
	CommService commService;
	
	/*
	 *  employeeAD.html에 관한 컨트롤러
	 */
	
	
	 // ajax 전체 조회(직원관리 데이터 불러오기)
	 @GetMapping("ajax/selectEmp")
	 @ResponseBody 
	 public List<EmpVO> ajaxSelectAllEmp() {
		 return empService.ajaxSelectAllEmp();
	 }
	 
	
	// (직원관리-회원등록 select탭(부서명, 직급정보))
	@RequestMapping("/employeeAD")
	public String employeeAD(Model model) {
		model.addAttribute("depts", empService.selectDept());
		model.addAttribute("jobs", empService.selectCommCode("JOB-GRD"));
		return "comm/employeeAD";
	}
	
	// (직원관리-회원등록)
	
	@PostMapping("/ajax/insertEmp")
	@ResponseBody
	public int employeeInsert(EmpVO empVO, Model model) {
		System.out.println(empVO.getEmpId());
		int result = empService.inserEmpInfo(empVO);
		System.out.println("result = " + result);
		return result;
		
	}
	
	// (직원관리-회원수정)
	@PostMapping("/ajax/updateEmp")
	@ResponseBody
	public int employeeUpdate(EmpVO empVO, Model model) {
		System.out.println(empVO.getEmpNo());
		int result = empService.updateEmpInfo(empVO);
		System.out.println("result = " + result);
		return result;
	}
	
	// (직원관리-회원삭제)
	@PostMapping("/ajax/delEmp")
	@ResponseBody
	public int employeeDel(@RequestBody List<EmpVO> empVO, Model model) {
		System.out.println(empVO.get(0).getEmpId());
		int result = empService.deleteEmpInfo(empVO);
		return result;
	}
	
	// (직원관리-회원등록 아이디 중복 확인)
	@PostMapping("/ajax/selectEmpInfo")
	@ResponseBody
	public EmpVO employeeDel(EmpVO empVO) {
		return empService.selectEmpInfo(empVO.getEmpId()); 
	}
	
	
	/*
	 *  commCodeAD.html에 관한 컨트롤러
	 */
	
	// commCodeAd 페이지 불러오기
	@RequestMapping("commonCodeAD")
	public String commonCodeAd() {
		
		return "comm/commCodeAd";
	}
	
	// ajax 공통 코드 불러오기 
	@GetMapping("ajax/selectComm")
	@ResponseBody
	public List<CommVO> ajaxSelectComm() {
		return commService.ajaxSelectComm();
	}
	
	// ajax 상세 공통 코드 불러오기
	@PostMapping("ajax/selectCommd")
	@ResponseBody
	public List<CommdVO> ajaxSelectCommd(CommdVO commdVO){
		return commService.ajaxSelectDetailComm(commdVO);
	}
	
	// ajax 상세 공통 코드 등록
	@PostMapping("ajax/insertCommd")
	@ResponseBody
	public int ajaxInsertCommd(@RequestBody List<CommdVO> commdVO) {
		int result = commService.ajaxInsertDetailComm(commdVO);
		return result;
	}
	
	// ajax 상세 공통 코드 삭제
	@PostMapping("ajax/delCommd")
	@ResponseBody
	public int ajaxDeleteCommd(@RequestBody List<CommdVO> commdVO){
		
		return commService.ajaxDeleteDetailComm(commdVO);
	}
	
	// ajax 공통 코드 등록
	@PostMapping("ajax/insertComm")
	@ResponseBody
	public int ajaxInsertComm(@RequestBody CommVO commVO) {
		int result = commService.ajaxInsertComm(commVO);
		return result;
	}
	
	
	/*
	 *  matCodeAD.html에 관한 컨트롤러
	 */
	
	
	// matCodeAd.html 화면 불러오기
	@RequestMapping("/matCodeAD")
	public String matCodeAD(Model model) throws JsonProcessingException {
		return "comm/matCodeAD";
	}
	
	
	// ajax 자재 코드 불러오기
	@GetMapping("ajax/selectMtr")
	@ResponseBody
	public List<MtrVO> ajaxSelectMtrCode(){
		
		return commService.ajaxSelectMat();
	}
	
	// ajax 자재 - 거래처 코드(모달) 불러오기
	
	@GetMapping("ajax/selectMtrModal")
	@ResponseBody
	public List<ActVO> ajaxSelectActModalCode(){
		
		return commService.ajaxSelectModalAct();
	}
	
	// ajax 자재 - 자재 단건 정보 가져오기
	@PostMapping("ajax/selectMtrInfo")
	@ResponseBody
	public MtrVO ajaxSelectMtrInfo(MtrVO mtrVO) {
		
		return commService.ajaxSelectMtrInfo(mtrVO);
	}
	
	/*
	 *  actCodeAD.html에 관한 컨트롤러
	 */
	
	// actCodeAd.html 화면 불러오기
	@RequestMapping("/actCodeAD")
	public String actCodeAD() {
		
		return "comm/actCodeAD";
	}
	
	// ajax 거래처 코드 불러오기
	@GetMapping("ajax/selectAct")
	@ResponseBody
	public List<ActVO> ajaxSelectActCode(){
		
		return commService.ajaxSelectAct();
	}
	
	/*
	 *  pdtCodeAD.html에 관한 컨트롤러
	 */
	
	// pdtCodeAD.html 화면 불러오기
	@RequestMapping("/pdtCodeAD")
	public String pdtCodeAD() {
		
		return "comm/pdtCodeAD";
	}
	
	// ajax 완제품 코드 불러오기
	@GetMapping("ajax/selectPrd")
	@ResponseBody
	public List<PrdVO> ajaxSelectPrdCode(PrdVO prdVO) {
		
		return commService.ajaxSelectPrd(prdVO);
	}
	
	/*
	 *  BOMAD.html에 관한 컨트롤러
	 */
	
	// BOMAD.html 화면 불러오기
	@RequestMapping("/BOMAD")
	public String emp() {
		
		return "comm/BOMAD";
	}
	
	// BOM 코드 불러오기(grid 화면출력)
	@GetMapping("ajax/selectBOM")
	@ResponseBody
	public List<BOMVO> ajaxSelectBOMCode(){
		
		return commService.ajaxSelectBOM();
	}
	
	// BOM 제품 목록 모달 불러오기
	@GetMapping("ajax/selectModalBOM")
	@ResponseBody
	public List<PrdVO> ajaxSelectModalBOM(){
		
		return commService.ajaxSelectModalBOM();
	}
	
}
