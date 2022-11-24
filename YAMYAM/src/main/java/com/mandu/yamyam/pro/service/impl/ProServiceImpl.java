package com.mandu.yamyam.pro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.pro.mapper.ProMapper;
import com.mandu.yamyam.pro.service.ProService;
import com.mandu.yamyam.pro.service.ProVO;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	ProMapper mapper;

	// 공통코드(공정분류)
	@Override
	public List<ProVO> getCommP() {
		return mapper.getCommP();
	}
	
	// 공통코드(에러코드)
	@Override
	public List<ProVO> getCommE() {
		return mapper.getCommE();
	}
	
	
	// 생산계획 조회
	@Override
	public List<ProVO> getPlan(ProVO vo) {
		return mapper.getPlan(vo);
	}
	
	// 상세생산계획 조회
	@Override
	public List<ProVO> planDetail(ProVO vo) {
		return mapper.getPlanDetail(vo);
	}
	
	// 생산계획 등록
	@Override
	public int insertPlan(List<ProVO> vo) {
		int result = 0;
		mapper.insertPlan(vo.get(0));
		mapper.updateBpod(vo.get(0));
		String code = vo.get(0).getPplnCd();
		for(int i=0; i<vo.size(); i++) {
			vo.get(i).setPplnCd(code);
			result += mapper.insertPlanDetail(vo.get(i));
		}
		return result;
	}
	
	// 상세생산계획 수정(작업우선순위, 생산일자)
	@Override
	public int updatePlanDetail(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			mapper.updatePlanDetail(vo.get(i));
		}
		return result;
	}
	
	
	// 생산계획 삭제
	@Override
	public int deletePlanDetail(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			mapper.deletePlanDetail(vo.get(i));
		}
		// detail건수 조회시 0이면 master 삭제
		int cnt = mapper.detailCnt(vo.get(0));
		if(cnt == 0) {
			mapper.deletePlan(vo.get(0));
		}
		return result;
	}
	
	
	// 생산요청서 모달 그리드 조회
	@Override
	public List<Map<String,Object>> orderList() {
		return mapper.orderList();
	}

	// 제품목록 조회
	@Override
	public List<Map<String,Object>> materialList() {
		return mapper.materialList();
	}
	
	// 입력될 생산 우선순위 조회
	@Override
	public int getPrioNo() {
		return mapper.getPrioNo();
	}
	
	/*---------------
	// 생산 지시 관리
	----------------*/
	// 미지시 계획 조회
	@Override
	public List<ProVO> noOrderList() {
		return mapper.noOrderList();
	}
	
	// 생산라인 조회
	@Override
	public List<Map<String, Object>> lineList(ProVO vo) {
		return mapper.lineList(vo);
	}
	

	// 생산지시 등록
	@Override
	public int insertOrder(List<ProVO> vo) {
		int result = 0;
		mapper.insertOrder(vo.get(0));
		String podCd = vo.get(0).getPodCd();
		
		for(int i =0; i<vo.size(); i++) {
			vo.get(i).setPodCd(podCd);
			result += mapper.insertOrderDetail(vo.get(i));
			mapper.updatePplnd(vo.get(i));
		}
		return result;
	}
	

	
	/*---------------
	// 생산 지시 조회
	----------------*/
	@Override
	public List<ProVO> getOrderList(ProVO vo) {
		return mapper.getOrderList(vo);
	}
	
	/*---------------
	// 생산 관리
	----------------*/
	// 지시완료된 생산지시 조회
	@Override
	public List<ProVO> getOProList(ProVO vo) {
		return mapper.getOProList(vo);
	}
	
	
	// 생산공정 수정(투입량)
	@Override
	public int updateProInAmt(ProVO vo) {
		return mapper.updateProInAmt(vo);
	}
	
	
	/*---------------
	// 공정 관리
	----------------*/
	@Override
	public List<ProVO> getProList(ProVO vo) {
		return mapper.getProList(vo);
	}
	
	// 제품공정 흐름도 조회
	@Override
	public List<ProVO> getFlowList(ProVO vo) {
		return mapper.getFlowList(vo);
	}
	
	
	
}
