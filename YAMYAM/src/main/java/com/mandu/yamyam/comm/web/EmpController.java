package com.mandu.yamyam.comm.web;

import java.util.List;
import java.util.Map;

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
import com.mandu.yamyam.common.GridData;
import com.mandu.yamyam.pro.service.ProVO;


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
	@RequestMapping("/commonCodeAD")
	public String commonCodeAd() {
		
		return "comm/commCodeAD";
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
	
	// ajax 상세 공통 코드 한건 불러오기
	@PostMapping("ajax/findCommd")
	@ResponseBody
	public CommdVO ajaxFindCommd(CommdVO commdVO){
		return commService.ajaxFindCommd(commdVO);
	}
	
	// ajax 상세 공통 코드(등록, 수정, 삭제)
	@PostMapping("ajax/modifiedCommd")
	@ResponseBody
	public Map<String, Object> ajaxModifiedCommd(@RequestBody GridData<CommdVO> gridData) {
		return commService.ajaxModifiedCommd(gridData);
	}
	
	
	/*
	 * // ajax 상세 공통 코드 등록
	 * 
	 * @PostMapping("ajax/insertCommd")
	 * 
	 * @ResponseBody public int ajaxInsertCommd(@RequestBody List<CommdVO> commdVO)
	 * { int result = commService.ajaxInsertDetailComm(commdVO); return result; }
	 * 
	 * // ajax 상세 공통 코드 수정
	 * 
	 * @PostMapping("ajax/updateCommd")
	 * 
	 * @ResponseBody public int ajaxUpdateCommd(@RequestBody List<CommdVO> commdVO)
	 * { return commService.ajaxUpdateCommd(commdVO); }
	 * 
	 * // ajax 상세 공통 코드 삭제
	 * 
	 * @PostMapping("ajax/delCommd")
	 * 
	 * @ResponseBody public int ajaxDeleteCommd(@RequestBody List<CommdVO> commdVO){
	 * 
	 * return commService.ajaxDeleteDetailComm(commdVO); }
	 */
	
	// ajax 공통 코드 등록
	@PostMapping("ajax/insertComm")
	@ResponseBody
	public int ajaxInsertComm(CommVO commVO) {
		int result = commService.ajaxInsertComm(commVO);
		return result;
	}
	
	// ajax 공통 코드 단건 조회 ajaxFindComm
	@PostMapping("ajax/findComm")
	@ResponseBody
	public CommVO ajaxFindComm(String commCd) {
		return commService.ajaxFindComm(commCd);
	}
	
	// ajax 공통 코드 수정
	@PostMapping("ajax/updateComm")
	@ResponseBody
	public int ajaxUpdateComm(CommVO commVO) {
		return commService.ajaxUpdateComm(commVO);
	}
	
	// ajax 공통 코드 삭제
	@PostMapping("ajax/deleteComm")
	@ResponseBody
	public int ajaxDeleteComm(CommVO commVO) {
		return commService.ajaxDeleteComm(commVO);
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
	
	// ajax 자재 - 자재 정보 등록
	@PostMapping("ajax/insertMtr")
	@ResponseBody
	public int ajaxInsertMtr(MtrVO mtrVO) {
		int result = commService.ajaxInsertMtr(mtrVO);
		return result;
	}
	
	// ajax 자재 - 자재 정보 수정
	
	@PostMapping("ajax/updateMtr")
	@ResponseBody
	public int ajaxUpdateMtr(MtrVO mtrVO) {
		int result = commService.ajaxUpdateMtr(mtrVO);
		return result;
	}
	
	
	// ajax 자재 - 자재 정보 삭제
	@PostMapping("ajax/delMtr")
	@ResponseBody
	public int ajaxDeleteMtr(@RequestBody List<MtrVO> mtrVO) {
		int result = commService.ajaxDeleteMtr(mtrVO);
		return result;
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
	
	// ajax 구매 거래처 등록
	@PostMapping("ajax/insertAct")
	@ResponseBody
	public int ajaxInsertAct(ActVO actVO) {
		int result = 0;
		result = commService.ajaxInsertAct(actVO);
		return result;
	}
	
	// ajax 구매 거래처 수정
	@PostMapping("ajax/updateAct")
	@ResponseBody
	public int ajaxUpdateAct(ActVO actVO) {
		int result = 0;
		result = commService.ajaxUpdateAct(actVO);
		return result;
	}
	
	// ajax 구매 거래처 삭제
	@PostMapping("ajax/deleteAct")
	@ResponseBody
	public int ajaxDeleteAct(ActVO actVO) {
		return commService.ajaxDeleteAct(actVO);
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
	
	// ajax 완제품 코드 등록하기
	@PostMapping("ajax/insertPrd")
	@ResponseBody
	public int ajaxInsertPrd(PrdVO prdVO) {
		int result = 0;
		result = commService.ajaxInsertPrd(prdVO);
		return result;
	}
	
	// ajax 완제품 코드 삭제하기
	@PostMapping("ajax/delPrd")
	@ResponseBody
	public int ajaxDeletePrd(@RequestBody List<PrdVO> prdVO) {
		int result = 0;
		result = commService.ajaxDeletePrd(prdVO);
		return result;
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
	
	// BOM 제품 목록 모달 불러오기(grid2)
	@GetMapping("ajax/selectModalBOM")
	@ResponseBody
	public List<PrdVO> ajaxSelectModalBOM(){
		
		return commService.ajaxSelectModalBOM();
	}
	
	// ajax BOM 사용공정명(모달창(grid3))
	@GetMapping("ajax/SelectProInfoModalBOM")
	@ResponseBody
	public List<ProVO> ajaxSelectProInfoModalBOM(){
		
		return commService.ajaxSelectProInfoModalBOM();
	}
	
	// ajax BOM 사용공정명(모달창(grid4))
	@GetMapping("ajax/SelectPrdInfoModalBOM")
	@ResponseBody
	public List<PrdVO> ajaxSelectPrdInfoModalBOM(){
		
		return commService.ajaxSelectPrdInfoModalBOM();
	}
	
	// ajax BOM 사용공정명(모달창(grid5))
	@GetMapping("ajax/SelectMtrInfoModalBOM")
	@ResponseBody
	public List<MtrVO> ajaxSelectMtrInfoModalBOM(){
		
		return commService.ajaxSelectMtrInfoModalBOM();
	}
	
	// ajax 상세 공통 코드(등록, 수정, 삭제)
	@PostMapping("ajax/modifiedBOM")
	@ResponseBody
	public Map<String, Object> ajaxModifiedBOM(@RequestBody GridData<BOMVO> gridData) {
		return commService.ajaxModifiedBOM(gridData);
	}
	
	// ajax BOM 추가 후 저장하기
	@PostMapping("ajax/insertBOM")
	@ResponseBody
	public int ajaxInsertBOM(@RequestBody List<BOMVO> bomVO) {
		int result = 0;
		result = commService.ajaxInsertBOM(bomVO);
		
		return result;
	}
	
	// ajax BOM 수정(BOM코드가 있을경우 수정, 없으면 등록)
	
	@PostMapping("ajax/updateBOM")
	@ResponseBody
	public int ajaxUpdateBOM(@RequestBody List<BOMVO> bomVO) {
		return commService.ajaxUpdateBOM(bomVO);
	}
	
	// ajax BOM 삭제 하기
	@PostMapping("ajax/deleteBOM")
	@ResponseBody
	public int ajaxDeleteBOM(@RequestBody List<BOMVO> bomVO) {
		int result = 0;
		result = commService.ajaxDeleteBOM(bomVO);
		
		return result;
	}
	
	// ajax BOM Filter
	@PostMapping("ajax/selectFilterBOM")
	@ResponseBody
	public List<BOMVO> ajaxFilterBOM(BOMVO bomVO) {
		return commService.ajaxFilterBOM(bomVO);
	}
	
}
