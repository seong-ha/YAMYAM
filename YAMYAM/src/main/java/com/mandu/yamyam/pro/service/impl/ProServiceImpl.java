package com.mandu.yamyam.pro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.comm.service.EmpVO;
import com.mandu.yamyam.pro.mapper.ProMapper;
import com.mandu.yamyam.pro.service.ProService;
import com.mandu.yamyam.pro.service.ProVO;

@Service
public class ProServiceImpl implements ProService {

	@Autowired
	ProMapper mapper;

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
	
	
	/*---------------
	// 생산 지시 관리
	----------------*/
	// 미지시 계획 조회
	@Override
	public List<ProVO> noOrderList(ProVO vo) {
		return mapper.noOrderList(vo);
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
	
	
	// 설비상태 수정, 입고량 수정
	@Override
	public int updateEqpSts(ProVO vo) {
		int result = 0;
		mapper.updateEqpSts(vo);
		String pproCd = vo.getPproCd();
		if(pproCd != null) {
			mapper.updateProInAmt(vo);
		}
		return result;
	}
	
	// 제품 공정 목록 조회
	@Override
	public List<ProVO> flowProgress(ProVO vo) {
		return mapper.flowProgress(vo);
	}

	// 제품 공정 목록 조회 (생산시작후)
	@Override
	public List<ProVO> afterProgress(ProVO vo) {
		return mapper.afterProgress(vo);
	}
	
	
	/*---------------
	// 공정 관리
	----------------*/
	@Override
	public List<ProVO> getProList(ProVO vo) {
		return mapper.getProList(vo);
	}
	
	// 미사용설비 조회
	@Override
	public List<ProVO> noUseEqp() {
		return mapper.noUseEqp();
	}
	
	// 생산담당 직원 조회
	public List<EmpVO> getProEmpList(){
		return mapper.getProEmpList();
	};
	
	
	// 공정 등록
	@Override
	public int insertProManage(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += mapper.insertProManage(vo.get(i));
		}
		return result;
	}
	
	// 공정 수정
	@Override
	public int updateProManage(ProVO vo) {
		return mapper.updateProManage(vo);
	}
	
	// 공정 삭제
	@Override
	public int deleteProManage(List<ProVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += mapper.deleteProManage(vo.get(i));
		}
		return result;
	}
	
	// 완제품 재고 등록
	@Override
	public int insertBIn(ProVO vo) {
		int result = 0;
		mapper.insertBIn(vo);
		mapper.insertPRecord(vo);
		mapper.resertPpro(vo);
		return result;
	}
		

	// 공정실적조회
	@Override
	public List<ProVO> getResultList(ProVO vo) {
		return mapper.getResultList(vo);
	}
	
	
	// 제품공정 흐름도 조회
	@Override
	public List<ProVO> getFlowList(ProVO vo) {
		return mapper.getFlowList(vo);
	}
	
	// 제품 공정 흐름도 관리
	@Override
	public List<ProVO> flowManage(ProVO vo) {
		return mapper.flowManage(vo);
	}
	
	// 공정 목록 조회
	@Override
	public List<ProVO> viewProgress(ProVO vo) {
		return mapper.viewProgress(vo);
	}
	
	// 생산라인 저장
	@Override
	public int insertPline(List<ProVO> vo) {
		int result = 0;
		// 생산라인 1건 저장
		mapper.insertPline(vo.get(0));
		// 생산공정 해당하는건수만큼 수정
		for(int i=0; i<vo.size(); i++) {
			result += mapper.updatePline(vo.get(i));
		}
		return result;
	}
	
	
}
