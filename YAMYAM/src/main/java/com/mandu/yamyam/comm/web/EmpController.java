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

import com.mandu.yamyam.comm.service.ActVO;
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
	public List<CommdVO> ajaxInsertCommd(@RequestBody List<CommdVO> commdVO) {
		
		return commService.ajaxInsertDetailComm(commdVO);
	}
	
	
	/*
	 *  matCodeAD.html에 관한 컨트롤러
	 */
	
	@RequestMapping("/matCodeAD")
	public String matCodeAD() {
		
		return "comm/matCodeAD";
	}
	
	
	/*
	 *  actCodeAD.html에 관한 컨트롤러
	 */
	
	
	// matCodeAd.html 화면 불러오기
	@RequestMapping("/actCodeAD")
	public String actCodeAD() {
		
		return "comm/actCodeAD";
	}
	
	// ajax 자재 코드 불러오기
	
	@GetMapping("ajax/selectMtr")
	@ResponseBody
	public List<MtrVO> ajaxSelectMtrCode(){
		
		return commService.ajaxSelectMat();
	}
	
	// ajax 자재 탭에 거래처검색(모달) 정보 불러오기
	
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
	public List<PrdVO> ajaxSelectPrdCode() {
		
		return commService.ajaxSelectPrd();
	}
	
	/*
	 *  BOMAD.html에 관한 컨트롤러
	 */
	
	@RequestMapping("/BOMAD")
	public String emp() {
		
		return "comm/BOMAD";
	}
	
	
	
}
