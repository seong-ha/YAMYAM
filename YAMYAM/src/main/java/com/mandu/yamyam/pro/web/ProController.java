package com.mandu.yamyam.pro.web;

import java.util.List;

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
	
	// 생산계획(관리탭)
	
	// 생산계획
	@RequestMapping("/proPlan")
	public String plan(Model model) {
		
		return "production/proPlan";
	}
	
	// 상세생산계획조회
	@GetMapping("/plandList")
	@ResponseBody // response contentType : json
	public List<ProVO> planDetail() {
		
		return service.planDetail();
	}
	
	// 상세생산계획 수정()
	@PostMapping("/planUpdate")
	@ResponseBody
	public int updatPlanDetail(@RequestBody ProVO vo) {
		vo.getPplndCd();
		vo.getPplndPrio();
		vo.getPplndDays();
		return service.updatePlanDetail(vo);
	}
	
	// 생산계획(등록탭)
	@PostMapping("/planInsert")
	@ResponseBody
	public int insertPlanDetail() {
		return 0;
	}
	
	// 생산요청서 모달 그리드 조회
	@RequestMapping("/getOrderList")
	@ResponseBody
	public List<ProVO> getOrderList(){
		return service.orderList();
	}
	
	// 생산지시관리
	@RequestMapping("/proOrder")
	public String order(Model model) {
		return "production/proOrder";
	}
	
	// 생산지시조회
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
