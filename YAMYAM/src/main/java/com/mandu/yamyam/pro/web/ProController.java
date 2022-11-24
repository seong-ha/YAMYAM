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
	
	// 필요자재LOT목록 조회
	// 필요자재 조회
	@RequestMapping("/getMLOTList")
	@ResponseBody
	public List<ProVO> getLotList(ProVO vo){
		return service.mLotList(vo);
	}
	
	// 생산지시 추가
	@PostMapping("/orderInsert")
	@ResponseBody
	public int orderInsert(@RequestBody List<ProVO> vo) {
		return service.insertOrder(vo);
	}
	
	// 자재 재고 업데이트
	@PostMapping("/miUpdate")
	@ResponseBody
	public int miUpdatet(@RequestBody List<ProVO> vo) {
		return service.updateMin(vo);
	}
	
	
	/*---------------
	// 생산지시조회
	----------------*/
	@RequestMapping("/viewOrderList")
	@ResponseBody
	public List<ProVO> getOrderList(ProVO vo){
		return service.getOrderList(vo);
	}
	
	@RequestMapping("/planOrdCheck")
	public String orderCheck(Model model) {
		return "production/planOrdCheck";
	}
	
	/*---------------
	// 생산관리
	----------------*/
	
	// 생산관리
	@RequestMapping("/proOrdManage")
	public String proOrdManage(Model model) {
		return "production/proOrdManage";
	}
	
	// 생산지시 목록 조회
	@RequestMapping("/getOProList")
	@ResponseBody
	public List<ProVO> getOProList(ProVO vo){
		return service.getOProList(vo);
	}
	
	
	// 공정 실적 조회
	@RequestMapping("/proResult")
	public String proResult(Model model) {
		model.addAttribute("eCode", service.getCommE());
		return "production/proResult";
	}
	
	// 공정 관리
	@RequestMapping("/proManage")
	public String proManage(Model model) {
		model.addAttribute("pCode", service.getCommP());
		return "production/proManage";
	}
	
	// 제품공정흐름도 조회
	@RequestMapping("/getProList")
	@ResponseBody
	public List<ProVO> getProList(ProVO vo){
		return service.getProList(vo);
	}
	
	/*---------------
	// 공정 흐름도
	----------------*/
	
	// 공정 흐름도
	@RequestMapping("/flowDiagram")
	public String flowDiagram(Model model) {
		return "production/flowDiagram";
	}
	
	// 제품공정흐름도 조회
	@RequestMapping("/getFlow")
	@ResponseBody
	public List<ProVO> getFlow(ProVO vo){
		return service.getFlowList(vo);
	}
	
	// 공정 모니터링
	@RequestMapping("/monitoring")
	public String monitoring(Model model) {
		return "production/monitoring";
	}
}
