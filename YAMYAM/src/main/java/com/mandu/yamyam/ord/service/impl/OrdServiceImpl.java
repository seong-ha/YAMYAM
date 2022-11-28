package com.mandu.yamyam.ord.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.ord.mapper.OrdMapper;
import com.mandu.yamyam.ord.service.OrdService;
import com.mandu.yamyam.ord.service.OrdVO;
@Service
public class OrdServiceImpl implements OrdService {

	@Autowired
	OrdMapper map;
	
	/*------------
	// 	 Modal
	---------------*/
	
	// 거래처 Modal 조회
	@Override
	public List<OrdVO> actList() {
		return map.actList();
	}
	
	// 제품명 Modal 조회
	@Override
	public List<OrdVO> prdList() {
		return map.prdList();
	}
	
	// 완제품LOT Modal 조회
	@Override
	public List<OrdVO> lotList() {
		return map.lotList();
	}
	
	// 완제품LOT 재고 현황 모달
	@Override
	public List<OrdVO> lotSList() {
		return map.lotSList();
	}
	
	// 완제품LOT 출고 현황 모달
	@Override
	public List<OrdVO> lotOutList() {
		return map.lotOutList();
	}
	
	// 주문서 관리 모달
	@Override
	public List<OrdVO> ordList() {
		return map.ordList();
	}
	
	
	/*------------
	// 주문 관리 Tab
	---------------*/
	
	// 주문서관리 리스트 조회
	@Override
	public List<OrdVO> getOrdList() {
		return map.getOrdList();
	}
	
	// 주문서관리 주문서 조건조회
	@Override
	public List<OrdVO> getList(OrdVO vo) {
		return map.getList(vo);
	}
	
	// 주문서 관리 추가
	@Override
	public int insertOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.insertOrd(vo.get(i));
		}
		return result;
	}
	
	// 주문서 관리 수정
	@Override
	public int updateOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.updateOrd(vo.get(i));
		}
		return result;
	}
	
	// 주문서 관리 삭제
	@Override
	public int deleteOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.deleteOrd(vo.get(i));
		}
		return result;
	}

	
	/*-----------------
	// 완제품 출고 조회 Tab
	-------------------*/
	
	// 출고 내역 리스트 조회
	@Override
	public List<OrdVO> getOrdOutList() {
		return map.getOrdOutList();
	}
	
	// 출고 내역 리스트 조건조회
	@Override
	public List<OrdVO> getDetailOutList(OrdVO vo) {
		return map.getDetailOutList(vo);
	}

	/*-----------------
	// 완제품 출고 관리 Tab
	-------------------*/
	
	// 진행중인 주문서 리스트 조회
	@Override
	public List<OrdVO> getIngOrdList() {
		return map.getIngOrdList();
	}

	// 진행중인 주문서 조건조회
	@Override
	public List<OrdVO> getIngOrdDetailList(OrdVO vo) {
		return map.getIngOrdDetailList(vo);
	}

	// 출고 등록 리스트 등록
	@Override
	public int insertOutList(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.insertOutList(vo.get(i));
		}
		return result;
	}

	// 출고 등록 리스트 삭제
	@Override
	public int deleteOutList(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.deleteOutList(vo.get(i));
		}
		return result;
	}

	/*-----------------
	// 완제품 반품 관리 Tab
	-------------------*/
	// 완제품 반품 관리 리스트 조회
	@Override
	public List<OrdVO> getReList(OrdVO vo) {
		return map.getReList(vo);
	}

	// 완제품 반품 관리 리스트 등록
	@Override
	public int insertReList(OrdVO vo) {
		return map.insertReList(vo);
	}
	
	@Override
	// 완제품 반품 관리 리스트 수정
	public int updateReList(OrdVO vo) {
		return map.updateReList(vo);
	}

	/*-----------------
	// 완제품 재고 조회 Tab
	-------------------*/
	// 완제품 재고 리스트 조회
	@Override
	public List<OrdVO> getLotList(OrdVO vo) {
		return map.getLotList(vo);
	}
	
	/*-----------------
	// 완제품 재고 관리 Tab
	-------------------*/
	// 완제품 유통기한 현황 리스트 조회
	@Override
	public List<OrdVO> getEdateList(OrdVO vo) {
		return map.getEdateList(vo);
	}
	
	// 완제품 폐기 등록 현황 리스트 조회
	@Override
	public List<OrdVO> getAgAmtList(OrdVO vo) {
		return map.getAgAmtList(vo);
	}
	
	// 완제품 폐기 리스트 등록
	@Override
	public int insertEdateList(OrdVO vo) {
		return map.insertEdateList(vo);
	}
	
	// 완제품 폐기 리스트 수정
	@Override
	public int updateEdateList(OrdVO vo) {
		return map.updateEdateList(vo);
	}
	
	/*-----------------
	// 생산 요청 관리 Tab
	-------------------*/
	
	// 생산 요청 관리 리스트 조회
	@Override
	public List<OrdVO> getPodList() {
		return map.getPodList();
	}

	// 생산 요청 관리 주문서 조건조회
	@Override
	public List<OrdVO> getPodDetailList(OrdVO vo) {
		return map.getPodDetailList(vo);
	}

	// 생산 요청 관리 추가
	@Override
	public int insertPodOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.insertPodOrd(vo.get(i));
		}
		return result;
	}

	// 생산 요청 관리 수정
	@Override
	public int updatePodOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.updatePodOrd(vo.get(i));
		}
		return result;
	}

	// 생산 요청 관리 삭제
	@Override
	public int deletePodOrd(List<OrdVO> vo) {
		int result = 0;
		for(int i=0; i<vo.size(); i++) {
			result += map.deletePodOrd(vo.get(i));
		}
		return result;
	}

	
	/*-------------------
	// 제품 안전 재고 관리 Tab
	---------------------*/
	
	// 안전 재고 관리 리스트 조회
	@Override
	public List<OrdVO> getSfamtList(OrdVO vo) {
		return map.getSfamtList(vo);
	}

}
