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
import com.mandu.yamyam.pro.service.ProVO;

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
	
	// 완제품LOT Modal 조회 (재고 조회 Tab)
	@GetMapping("lotDetailListModal")
	@ResponseBody
	public List<OrdVO> lotDetailList() {
		return service.lotDetailList();
	}
	
	// 완제품LOT 재고 현황 모달
	@GetMapping("lotSListModal")
	@ResponseBody
	public List<OrdVO> lotSList(OrdVO vo) {
		return service.lotSList(vo);
	}
	
	// 완제품LOT 출고 현황 모달
	@GetMapping("lotOutListModal")
	@ResponseBody
	public List<OrdVO> lotOutList() {
		return service.lotOutList();
	}
	
	// 주문서 관리 모달
	@GetMapping("ordModal")
	@ResponseBody
	public List<OrdVO> ordList() {
		return service.ordList();
	}
	
	/*-----------------
	//   주문 관리 Tab
	-------------------*/
	
	// 주문서 관리 리스트 조회 (단건, 조건조회)
	@GetMapping("ordList")
	@ResponseBody
	public List<OrdVO> getOrdList(OrdVO vo) {
		return service.getOrdList(vo);
	}
	
	// 주문서 관리 신규등록
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
	public List<OrdVO> getOrdOutList(OrdVO vo) {
		return service.getOrdOutList(vo);
	}
	
	
	
	/*-----------------
	// 완제품 출고 관리 Tab
	-------------------*/
	
	// 진행중인 리스트 조회
	@GetMapping("ingOrdList")
	@ResponseBody
	public List<OrdVO> getIngOrdList(OrdVO vo) {
		return service.getIngOrdList(vo);
	}
	
	// 출고 등록 리스트 등록 및 재고 수정
	@PostMapping("insertOutList")
	@ResponseBody
	public int insertOutList(@RequestBody List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += service.insertOutList(vo.get(i));
		}
		for (int i=0; i<vo.size(); i++) {
		result += service.updateOutList(vo.get(i));
		}
		for (int i=0; i<vo.size(); i++) {
		result += service.updateOrdStsList(vo.get(i));
		}
		return result;
	}
	
	
	
	/*-----------------
	// 완제품 반품 관리 Tab
	-------------------*/
	// 완제품 반품 관리 리스트 조회
	@GetMapping("reList")
	@ResponseBody
	public List<OrdVO> getReList(OrdVO vo) {
		return service.getReList(vo);
	}
	
	// 완제품 반품 관리 리스트 등록 및 재고 수정
	@PostMapping("insertReList")
	@ResponseBody
	public int insertReList(@RequestBody List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += service.insertReList(vo.get(i));
		}
		for(int i=0; i<vo.size(); i++) {
			result += service.updateReList(vo.get(i));
		}
		return result;
	}
	
	
	
	/*-----------------
	// 완제품 재고 조회 Tab
	-------------------*/
	// 완제품 재고 리스트 조회
	@GetMapping("getLotList")
	@ResponseBody
	public List<OrdVO> getLotList(OrdVO vo) {
		return service.getLotList(vo);
	}
	
	
	
	/*-----------------
	// 완제품 재고 관리 Tab
	-------------------*/
	// 완제품 유통기한 현황 리스트 조회
	@GetMapping("getEdateList")
	@ResponseBody
	public List<OrdVO> getEdateList(OrdVO vo) {
		return service.getEdateList(vo);
	}
	
	// 완제품 폐기 등록 리스트 조회
	@GetMapping("getAgAmtList")
	@ResponseBody
	public List<OrdVO> getAgAmtList(OrdVO vo) {
		return service.getAgAmtList(vo);
	}
	
	@PostMapping("insertEdateList")
	@ResponseBody
	// 완제품 폐기 리스트 등록 및 수정
	public int insertEdateList(@RequestBody OrdVO vo) {
		int result = 0;
			result += service.insertEdateList(vo);
			result += service.updateEdateList(vo);
		return result;
	}
	
	/*-----------------
	// 생산 요청 관리 Tab
	-------------------*/
	
	// 생산 요청 관리 리스트 조회
	@GetMapping("PodList")
	@ResponseBody
	public List<OrdVO> getPodList() {
		return service.getPodList();
	}
		
	// 생산 요청 관리 주문서 조건조회
	@GetMapping("PodDetailList")
	@ResponseBody
	public List<OrdVO> getPodDetailList(OrdVO vo) {
		return service.getPodDetailList(vo);
	}
	
	// 생산 요청 관리 리스트 등록
	@PostMapping("insertPodList")
	@ResponseBody
	public int insertPodList(@RequestBody List<OrdVO> vo) {
		int result =  service.insertPodOrd(vo);
		return result;
	}
	
	// 생산 요청 관리 리스트 수정
	@PostMapping("updatePodList")
	@ResponseBody
	public int updatePodList(@RequestBody List<OrdVO> vo) {
		int result =  service.updatePodOrd(vo);	
		return result;
	}
	
	// 생산 요청 관리 리스트 삭제
	@DeleteMapping("deletePodList")
	@ResponseBody
	public int deletePodList(@RequestBody List<OrdVO> vo) {
		int result = service.deletePodOrd(vo);
		return result;
	}
	
	/*-------------------
	// 제품 안전 재고 관리 Tab
	---------------------*/
	
	// 안전 재고 관리 리스트 조회
	@GetMapping("getSfamtList")
	@ResponseBody
	public List<OrdVO> getSfamtList(OrdVO vo) {
		return service.getSfamtList(vo);
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
