package com.mandu.yamyam.mat.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandu.yamyam.comm.service.CommService;
import com.mandu.yamyam.mat.service.MatOdService;
import com.mandu.yamyam.mat.service.MatVO;

// 2022-11 이현성
@Controller
public class MatController {

	@Autowired
	MatOdService service;
	
	@Autowired
	CommService commService;
	
	//======================
	// 1) 자재 발주 관리
	//======================
	// 자재 발주 관리 - 전체 조회(일반 탭)
	@GetMapping("/matOd")
	public String matOd(Model model) {
		model.addAttribute("matList", service.matList());			// 돋보기 자재목록 모달
		model.addAttribute("actList", service.actList());			// 돋보기 업체목록 모달
		model.addAttribute("oderN", service.matOderN7());			// 기본 전체 조회
		model.addAttribute("newPlanList", service.newPlanList());	// 신규생산계획조회(생산계획서용 탭)
		model.addAttribute("addNewPlan", service.addNewPlan());		// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
		return "mat/matOd";
	}
	
	@PostMapping("/matOdList")
	@ResponseBody
	public List<Map<String,Object>> matOdAllList(@RequestBody MatVO vo){
		return service.matOrderList(vo);							// 자재발주관리 리스트(일반 탭)
	}
	
	// 자재 발주 관리 - 단건 delete (일반 탭)
	@DeleteMapping("/matOd")
	@ResponseBody
	public int delMatOd(@RequestBody MatVO vo) {
		int result = service.delMatOd(vo);
		return result;
	}
	
	// 자재 발주 관리 - 자재발주코드 여러 건 delete (일반 탭)
	@DeleteMapping("/matOdDel")
	@ResponseBody
	public int delMatOdList(@RequestBody List<MatVO> list) {
		int result = service.delMatOdList(list);
		return result;
	}
	
	// 자재 발주 관리 - 자재발주상세코드 여러 건 delete
	@DeleteMapping("/matOddDel")
	@ResponseBody
	public int delMatOddList(@RequestBody List<MatVO> list) {
		int result = service.delMatOddList(list);
		return result;
	}
	
	// 자재 발주 관리 - insert (일반 탭)
	@PostMapping("/matOd")
	@ResponseBody
	public int insMatOd(@RequestBody List<MatVO> list) {
		int result = service.insMatOdList(list);
		return result;
	}
	
	// 신규 생산계획 추가 데이터.
	@PostMapping("/matAddNewPlan")
	@ResponseBody
	public List<Map<String,Object>> addNewPlan(@RequestBody MatVO vo){
		return service.newPlanInfo(vo);
	}
	
	// 필요 자재 리스트(자재 발주 - 생산계획 탭)
	@PostMapping("/needMatList")
	@ResponseBody
	public List<Map<String,Object>> needMatList(@RequestBody MatVO vo){
		return service.needMatList(vo);
	}
	
	// 자재 발주 리스트 날짜 조회(일반 탭)
	@PostMapping("/odListDtLookUpBtn")
	@ResponseBody
	public List<Map<String,Object>> odListDtLookUpBtn(@RequestBody MatVO vo){
		return service.odListDtLookUpBtn(vo);
	}
	
	// 신규 생산 계획서 리스트 날짜 조회(자재 발주 - 생산계획 탭)
	@PostMapping("/newPlanLookUpBtn")
	@ResponseBody
	public List<Map<String,Object>> newPlanLookUpBtn(@RequestBody MatVO vo){
		return service.newPlanLookUpBtn(vo);
	}
	
	// 저장하면 자재팀확인 -> 미지시 업데이트
	@PutMapping("/matOd")
	@ResponseBody
	public int updatePlndSts(@RequestBody MatVO vo) {
		return service.updatePlndSts(vo);
	}
	
	//======================
	// 2) 자재 발주 조회
	//======================
	// 자재 발주 조회
	@RequestMapping("/matLookup")
	public String matLookup(Model model) {
		model.addAttribute("matLookUpAllList", service.matOdLookUpList());  // 자재전체조회 odList
		model.addAttribute("matList", service.matList());					// 돋보기 자재목록 모달
		model.addAttribute("actList", service.actList());					// 돋보기 업체목록 모달
		return "mat/matLookup";
	}
	
	// 발주 신청일 조회 버튼 클릭 이벤트 (자재 발주 조회 - 조건 조회 탭)
	@PostMapping("/odListSearch")
	@ResponseBody
	public List<Map<String,Object>> odListSearch(@RequestBody MatVO vo){
		return service.odListSearch(vo);
	}
	
	// 자재 발주 조회 - 신청일 클릭 시 나타나는 그리드 데이터
	@PostMapping("/clickOdInfo")
	@ResponseBody
	public List<Map<String,Object>> dateLookUpList(@RequestBody MatVO vo) {
		return service.clickOdDate(vo);
	}
	

	//======================
	// 3) 자재 입고 검수 관리
	//======================
	// 자재 입고 검수
	@RequestMapping("/matInChk")
	public String matInChk(Model model) {
		model.addAttribute("chkOd", service.chkOdList7());				// 7일치 기본 조회
		model.addAttribute("addChkList", service.addChkModal());
		model.addAttribute("errorList", service.erCdErInfoLookUp());	// 불량 목록 모달
		model.addAttribute("matList", service.matList());				// 돋보기 자재 목록 모달
		model.addAttribute("empList", service.empLookUp());				// 담당자 목록 모달
		model.addAttribute("commList", commService.getCommdCdNm("ERR-MNP"));
		return "mat/matInChk";
	}
	
	@PostMapping("/matInChk")
	@ResponseBody
	public List<Map<String, Object>> matInChkAllList(@RequestBody MatVO vo) {
		return service.chkOdMatList(vo);	// 자재입고검수관리 조회 그리드
	}
	
	// 자재 입고 검수 insert
	@PostMapping("/ChkOd")
	@ResponseBody
	public int insChkOd(@RequestBody List<MatVO> list) {
		int result = service.insertChkOd(list);
		return result;
	}
	
	// update
	@PostMapping("/updateChk")
	@ResponseBody
	public int updateMatOdSts(@RequestBody List<MatVO> list) {
		int result = service.updateMatOdSts(list);
		return result;
	}
	
	// 자재 입고 검수 delete
	@DeleteMapping("/ChkOd")
	@ResponseBody
	public int delChkOd(@RequestBody List<MatVO> list) {
		int result = service.deletetChkOd(list);
		return result;
	}
	
	//======================
	// 4) 자재 입고 관리
	//======================
	@RequestMapping("/matIn")
	public String matIn(Model model) {
		model.addAttribute("matInList", service.matInList());		// 기본 전체 조회
		model.addAttribute("matList", service.matList());			// 돋보기 자재 목록 모달
		model.addAttribute("actList", service.actList());			// 돋보기 업체 목록 모달
		model.addAttribute("bfInList", service.beforeInList());		// 입고 예정 목록 모달
		return "mat/matIn";
	}
	
	@PostMapping("/matIn")
	@ResponseBody
	public List<Map<String, Object>> matInAllList(@RequestBody MatVO vo) {
		return service.matInAllList(vo);	// 입고 전체 조회
	}
	
	// 자재 입고 관리 insert
	@PostMapping("/inManage")
	@ResponseBody
	public int inManageInsert(@RequestBody List<MatVO> list) {
		int result = service.inManageSave(list);
		return result;
	}
	
	// update 
	@PostMapping("/updateInsts")
	@ResponseBody
	public int updateMatInsts(@RequestBody List<MatVO> list) {
		int result = service.updateMatInsts(list);
		return result;
	}
	
	// 자재 입고 관리 delete
	@DeleteMapping("/inManage")
	@ResponseBody
	public int inManageDelete(@RequestBody List<MatVO> list) {
		int result = service.inManageDelete(list);
		return result;
	}
	
	//======================
	// 5) 자재 출고 관리
	//======================
	@RequestMapping("/matOut")
	public String matOut(Model model) {
		model.addAttribute("pOdList", service.pOdAllList());
		return "mat/matOut";
	}
	
	// 필요자재
	@PostMapping("/needMtrList")
	@ResponseBody
	public List<Map<String,Object>> needMtrList(@RequestBody MatVO vo){
		return service.needMtrList(vo);
	}
	
	// 필요자재LOT목록
	@PostMapping("/needLotList")
	@ResponseBody
	public List<Map<String,Object>> needMtrLotList(@RequestBody MatVO vo){
		return service.needMtrLotList(vo);
	}
	
	// 출고테이블로 insert
	@PostMapping("/insertOut")
	@ResponseBody
	public int insertMatOut(@RequestBody List<MatVO> list) {
		int result = service.insertMatOut(list);
		return result;
	}
	
	// 출고처리 - 재고 마이너스 업데이트
	@PostMapping("/matOut")
	@ResponseBody
	public int updateOutOd(@RequestBody List<MatVO> list) {
		return service.updateOutOd(list);
	}
	
	// 출고처리 - 완료로 업데이트
	@PostMapping("/updateOutSts")
	@ResponseBody
	public int updateOutSts(@RequestBody MatVO vo) {
		return service.updateOutSts(vo);
	}
	
	//======================
	// 6) 자재 입출고 조회
	//======================
	@RequestMapping("/matInOut")
	public String matInOut(Model model) {
		model.addAttribute("matInList", service.inOutAllList());    // 입고 전체조회
		model.addAttribute("matOutList", service.outInAllList());    // 출고 전체조회
		model.addAttribute("matList", service.matList());			// 자재목록
		model.addAttribute("actList", service.actList());			// 업체목록
		return "mat/matInOut";
	}
	
	// 입고 조건 조회
	@PostMapping("/searchInOutList")
	@ResponseBody
	public List<Map<String, Object>> selectInOutAllList(@RequestBody MatVO vo){
		return service.selectInOutAllList(vo);
	};
	
	// 출고 조건 조회
	@PostMapping("/searchOutInList")
	@ResponseBody
	public List<Map<String, Object>> selectOutInAllList(@RequestBody MatVO vo){
		return service.selectOutInAllList(vo);
	};
	
	//======================
	// 7) 자재 재고 조회
	//======================
	@RequestMapping("/matStockLookup")
	public String matStockLookup(Model model) {
		model.addAttribute("matStList", service.matStockList());	// 재고 전체조회
		model.addAttribute("holdAmt", service.getHoldAmt());		// 홀딩수량
		model.addAttribute("matList", service.matList());			// 자재목록
		model.addAttribute("actList", service.actList());			// 업체목록
		return "mat/matStockLookup";
	}
	
	@PostMapping("/matStockLookup")
	@ResponseBody
	public List<Map<String, Object>> matStockSelectList(@RequestBody MatVO vo) {
		return service.matStockSelectList(vo);
	}
	
	//======================
	// 8) 자재 반품 관리
	//======================
	@RequestMapping("/matReturn")
	public String matReturn(Model model) {
		model.addAttribute("returnMtrList", service.returnMtrList());	// 반품예정목록
		model.addAttribute("mtrReList", service.mtrReturnAllList());	// 반품목록
		return "mat/matReturn";
	}
	
	// 전체리스트 행 클릭시 조회
	@PostMapping("/matReturnLookup")
	@ResponseBody
	public List<Map<String, Object>> returnInfo(@RequestBody MatVO vo){
		return service.returnInfo(vo);
	}
	
	// insert
	@PostMapping("/insertRt")
	@ResponseBody
	public int insertReturnOd(@RequestBody MatVO vo) {
		return service.insertRtOd(vo);
	}
	
	// update
	@PostMapping("/updateRt")
	@ResponseBody
	public int updateReturnOd(@RequestBody MatVO vo) {
		return service.updateRtOd(vo);
	}
	
	//======================
	// 9) 자재 반품 조회
	//======================
	@RequestMapping("/matReturnLookup")
	public String matReturnLookup(Model model) {
		model.addAttribute("mtrReList", service.mtrReturnAllList());	// 전체리스트
		model.addAttribute("matList", service.matList());				// 자재목록
		model.addAttribute("actList", service.actList());				// 업체목록
		return "mat/matReturnLookup";
	}
	
	// 조건조회
	@PostMapping("/matReturnSearch")
	@ResponseBody
	public List<Map<String, Object>> matReturnSearch(@RequestBody MatVO vo) {
		return service.matReturnSearch(vo);
	}
	//======================
	// 10) 안전 재고 관리
	//======================
	@RequestMapping("/matSafe")
	public String matSafe(Model model) {
		model.addAttribute("matStList", service.mtrSamtList());		// 재고 전체조회
		model.addAttribute("holdAmt", service.getHoldAmt());		// 홀딩수량
		return "mat/matSafe";
	}
	
	// 안전재고 수정
	@PostMapping("/matSafe")
	@ResponseBody
	public int mtrSfUpdate(@RequestBody MatVO vo) {
		return service.mtrSfUpdate(vo);
	}
}
