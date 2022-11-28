package com.mandu.yamyam.ord.service;

import java.util.List;

public interface OrdService {
	
	/*-----------------
	//     Modal
	-------------------*/
	
	// 돋보기 업체목록 모달
	public List<OrdVO> actList();
	
	// 돋보기 제품목록 모달
	public List<OrdVO> prdList();
	
	// 돋보기 완제품LOT목록 모달
	public List<OrdVO> lotList();
	
	// 완제품LOT 재고 현황 모달
	public List<OrdVO> lotSList();
	
	// 완제품LOT 출고 현황 모달
	public List<OrdVO> lotOutList();
	
	// 주문서 관리 모달
	public List<OrdVO> ordList();
	
	
	/*-----------------
	//   주문 관리 Tab
	-------------------*/
	
	// 주문서 관리 리스트 조회
	public List<OrdVO> getOrdList();
	
	// 주문서 관리 주문서 조건조회
	public List<OrdVO> getList(OrdVO vo);
	
	// 주문서 관리 추가
	public int insertOrd(List<OrdVO> vo);
	
	// 주문서 관리 수정
	public int updateOrd(List<OrdVO> vo);
	
	// 주문서 관리 삭제
	public int deleteOrd(List<OrdVO> vo);
	
	
	/*-----------------
	// 완제품 출고 조회 Tab
	-------------------*/
	
	// 출고 내역 리스트 조회
	public List<OrdVO> getOrdOutList();
	
	// 출고 내역 리스트 조건조회
	public List<OrdVO> getDetailOutList(OrdVO vo);
	
	
	/*-----------------
	// 완제품 출고 관리 Tab
	-------------------*/
	
	// 진행중인 주문 리스트 조회
	public List<OrdVO> getIngOrdList();
	
	// 진행중인 주문 리스트 조건조회
	public List<OrdVO> getIngOrdDetailList(OrdVO vo);
	
	// 출고 등록 리스트 등록
	public int insertOutList(List<OrdVO> vo);
	
	// 출고 등록 리스트 삭제
	public int deleteOutList(List<OrdVO> vo);
	
	
	/*-----------------
	// 완제품 반품 관리 Tab
	-------------------*/
	// 완제품 반품 관리 리스트 조회
	public List<OrdVO> getReList(OrdVO vo);

	// 완제품 반품 관리 리스트 등록
	public int insertReList(List<OrdVO> vo);
	
	
	/*-----------------
	// 완제품 재고 조회 Tab
	-------------------*/
	// 완제품 재고 리스트 조회
	public List<OrdVO> getLotList(OrdVO vo);
	
	/*-----------------
	// 완제품 재고 관리 Tab
	-------------------*/
	// 완제품 유통기한 현황 리스트 조회
	public List<OrdVO> getEdateList(OrdVO vo);
	
	// 완제품 반품 관리 리스트 등록
	public int insertEdateList(List<OrdVO> vo);
	
	/*-----------------
	// 생산 요청 관리 Tab
	-------------------*/
	// 생산 요청 관리 리스트 조회
	public List<OrdVO> getPodList();
	
	// 생산 요청 관리 주문서 조건조회
	public List<OrdVO> getPodDetailList(OrdVO vo);
	
	// 생산 요청 관리 추가
	public int insertPodOrd(List<OrdVO> vo);
	
	// 생산 요청 관리 수정
	public int updatePodOrd(List<OrdVO> vo);
	
	// 생산 요청 관리 삭제
	public int deletePodOrd(List<OrdVO> vo);
}
