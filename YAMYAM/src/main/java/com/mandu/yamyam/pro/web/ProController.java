package com.mandu.yamyam.pro.web;

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

import com.mandu.yamyam.pro.service.ProService;
import com.mandu.yamyam.pro.service.ProVO;

@Controller
public class ProController {
	@Autowired
	ProService service;
	
	/*---------------
	// 생산 계획 관리(관리탭)
	----------------*/
	// 생산계획
	@RequestMapping("/proPlan")
	public String plan(Model model) {
		model.addAttribute("prioNo", service.getPrioNo());
		return "production/proPlan";
	}
	
	// 생산계획 조회
	@GetMapping("/planList")
	@ResponseBody // response contentType : json
	public List<ProVO> getPlan(ProVO vo) {
		return service.getPlan(vo);
	}
	
	// 상세생산계획조회
	@GetMapping("/plandList")
	@ResponseBody // response contentType : json
	public List<ProVO> planDetail(ProVO vo) {
		
		return service.planDetail(vo);
	}
	
	// 상세생산계획 수정(우선순위, 생사일자)
	@PostMapping("/planUpdate")
	@ResponseBody
	public int updatPlanDetail(@RequestBody List<ProVO> vo) {
		return service.updatePlanDetail(vo);
	}
	
	// 상세생산계획 삭제
	@PostMapping("/deleteDetail")
	@ResponseBody
	public int deleteDetail(@RequestBody List<ProVO> vo) {
		return service.deletePlanDetail(vo);
	}
	
	
	/*---------------
	// 생산 계획 관리(등록탭)
	----------------*/
	@PostMapping("/planInsert")
	@ResponseBody
	public int insertPlanDetail(@RequestBody List<ProVO> vo) {
		return service.insertPlan(vo);
	}

	
	// 생산요청서 모달 그리드 조회
	@RequestMapping("/getOrderList")
	@ResponseBody
	public List<Map<String,Object>> getOrderList(){
		return service.orderList();
	}
	
	// 제품목록 조회
	@RequestMapping("/getMList")
	@ResponseBody
	public List<Map<String,Object>> getMaterialList(){
		return service.materialList();
	}
	
	
	// 생산지시관리
	@RequestMapping("/proOrder")
	public String order(Model model) {
		return "production/proOrder";
	}
	
	
	/*---------------
	// 생산지시관리
	----------------*/
	// 미지시계획목록 조회
	@RequestMapping("/getNoOrder")
	@ResponseBody
	public List<ProVO> getNoOrderList(){
		return service.noOrderList();
	}
	
	// 생산지시 조회
	@RequestMapping("/proOrderList")
	@ResponseBody
	public List<Map<String,Object>> getProOrder(ProVO vo){
		return service.lineList(vo);
	}
	
	// 필요자재 조회
	@RequestMapping("/getNeed")
	@ResponseBody
	public List<ProVO> getNeedM(ProVO vo){
		return service.needM(vo);
	}
	
	/*---------------
	// 생산지시조회
	----------------*/
	@RequestMapping("/planOrdCheck")
	public String orderCheck(Model model) {
		return "production/planOrdCheck";
	}
		
	// 생산관리
	@RequestMapping("/proOrdManage")
	public String proOrdManage(Model model) {
		return "production/proOrdManage";
	}

	// 공정 실적 조회
	@RequestMapping("/proResult")
	public String proResult(Model model) {
		return "production/proResult";
	}
	
	// 공정 관리
	@RequestMapping("/proManage")
	public String proManage(Model model) {
		return "production/proManage";
	}
	
	// 공정 흐름도
	@RequestMapping("/flowDiagram")
	public String flowDiagram(Model model) {
		return "production/flowDiagram";
	}
	
	// 공정 모니터링
	@RequestMapping("/monitoring")
	public String monitoring(Model model) {
		return "production/monitoring";
	}
}
