package com.mandu.yamyam.ord.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mandu.yamyam.ord.service.OrdService;
import com.mandu.yamyam.ord.service.OrdVO;

@Controller
public class OrdController {
	
	@Autowired
	OrdService service;
	
	/*-----------------
	//     Modal
	-------------------*/
	
	// 거래처 Modal 조회
	@GetMapping("actListModal")
	@ResponseBody
	public List<OrdVO> actList() {
		return service.actList();
	}
	
	// 제품명 Modal 조회
	@GetMapping("prdListModal")
	@ResponseBody
	public List<OrdVO> prdList() {
		return service.prdList();
	}
	
	// 완제품LOT Modal 조회
	@GetMapping("lotListModal")
	@ResponseBody
	public List<OrdVO> lotList() {
		return service.lotList();
	}
	
	// 완제품LOT 재고 현황 모달
	@GetMapping("lotSListModal")
	@ResponseBody
	public List<OrdVO> lotSList() {
		return service.lotSList();
	}
	
	/*-----------------
	//   주문 관리 Tab
	-------------------*/
	
	// 주문서 조회
	@GetMapping("ordList")
	@ResponseBody
	public List<OrdVO> getOrdList() {
		return service.getOrdList();
	}
	
	// 주문서 조건조회
	@GetMapping("detailList")
	@ResponseBody
	public List<OrdVO> getList(OrdVO vo) {
		return service.getList(vo);
	}
	
	// 주문서 등록
	@PostMapping("insertOrd")
	@ResponseBody
	public int insertOrd(@RequestBody List<OrdVO> vo) {
		int result =  service.insertOrd(vo);
		return result;
	}
	
	// 주문서 수정
	@PostMapping("updateOrd")
	@ResponseBody
	public int updateOrd(@RequestBody List<OrdVO> vo) {
		int result =  service.updateOrd(vo);
		return result;
	}
	
	// 주문서 선택삭제
	@DeleteMapping("deleteOrd")
	@ResponseBody
	public int deleteOrd(@RequestBody List<OrdVO> vo) {
		int result = service.deleteOrd(vo);
		return result;
	}
	
	
	/*-----------------
	// 완제품 출고 조회 Tab
	-------------------*/
	
	// 출고 내역 리스트 조회
	@GetMapping("ordOutList")
	@ResponseBody
	public List<OrdVO> getOrdOutList() {
		return service.getOrdOutList();
	}
	
	// 출고 내역 리스트 조건조회
	@GetMapping("detailOutList")
	@ResponseBody
	public List<OrdVO> getDetailOutList(OrdVO vo) {
		return service.getDetailOutList(vo);
	}
	
	
	/*-----------------
	// 완제품 출고 관리 Tab
	-------------------*/
	
	// 진행중인 리스트 조회
		@GetMapping("ingOrdList")
		@ResponseBody
		public List<OrdVO> getIngOrdList() {
			return service.getIngOrdList();
		}
		
	// 진행중인 주문서 조건조회
	@GetMapping("ingOrdDetailList")
	@ResponseBody
	public List<OrdVO> getIngOrdDetailList(OrdVO vo) {
		return service.getIngOrdDetailList(vo);
	}
	
	// 출고 등록 리스트 등록
	@PostMapping("insertOutList")
	@ResponseBody
	public int insertOutList(@RequestBody List<OrdVO> vo) {
		int result =  service.insertOutList(vo);
		return result;
	}
	
	// 출고 등록 리스트 삭제
	@DeleteMapping("deleteOutList")
	@ResponseBody
	public int deleteOutList(@RequestBody List<OrdVO> vo) {
		int result = service.deleteOutList(vo);
		return result;
	}
	
	
	/*-----------------
	// 영업 관리 layout
	-------------------*/
	
	// 주문 관리
	@RequestMapping("/odAd") 
	public String odAd(Model model) {
		return "order/odAd";
	}
	
	// 완제품 출고 관리
	@RequestMapping("/prdOutAd") 
	public String prdOutAd(Model model) {
		return "order/prdOutAd";
	}
	
	// 완제품 출고 조회
	@RequestMapping("/prdOutList") 
	public String prdOutList(Model model) {
		return "order/prdOutList";
	}
	
	// 완제품 반품 관리
	@RequestMapping("/prdReAd") 
	public String prdReAd(Model model) {
		return "order/prdReAd";
	}
	
	// 완제품 재고 조회
	@RequestMapping("/prdList")
	public String prdList(Model model) {
		return "order/prdList";
	}
	
	// 완제품 재고 관리
	@RequestMapping("/prdAd")
	public String prdAd(Model model) {
		return "order/prdAd";
	}
	
	// 생산 요청 관리
	@RequestMapping("/podOrderAd")
	public String podOrderAd(Model model) {
		return "order/podOrderAd";
	}
	
	// 제품 안전 재고 관리
	@RequestMapping("/prdSfamtAd")
	public String prdSfamtAd(Model model) {
		return "order/prdSfamtAd";
	}
}
