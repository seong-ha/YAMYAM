package com.mandu.yamyam.eqp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
