package com.mandu.yamyam.eqp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mandu.yamyam.eqp.service.EqpService;
import com.mandu.yamyam.eqp.service.EqpVO;

@RestController
public class EqpRestController {
	@Autowired
	EqpService eqpService;
	
	// 설비 리스트 전체 조회
	@GetMapping("/getEqpList")
	public List<EqpVO> getEqpList() {
		return eqpService.getEqpList();
	}

	// 설비가동여부 리스트 조회
	@GetMapping("/eqpStsListModal")
	public List<EqpVO> getEqpListModal() {
		return eqpService.getEqpListModal();
	}
	
	// 설비 단건 조회
	@PostMapping("/getEqp")
	public EqpVO getEqp(EqpVO eqpVO) {
		System.out.println(eqpVO.getEqpCd());
		System.out.println(eqpService.getEqp(eqpVO));
		return eqpService.getEqp(eqpVO);
	}

	// 상세공통 설비구분 코드/명 조회
	@GetMapping("/eqpTypeListModal")
	public List<EqpVO> getEqpTypeListModal() {
		return eqpService.getEqpTypeListModal();
	}
	
	// 상세공통 설비구분 코드/명 조회
	@PostMapping("/eqpDelete")
	public int eqpDelete(@RequestBody List<EqpVO> list) {
		return eqpService.eqpDelete(list);
	}
}
