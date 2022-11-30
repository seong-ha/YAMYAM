package com.mandu.yamyam.ord.mapper;

import java.util.List;

import com.mandu.yamyam.ord.service.OrdVO;

public interface OrdMapper {

	/*-----------------
	// 	   Modal
	-------------------*/
	
	// 돋보기 업체목록 모달
	public List<OrdVO> actList();
	
	// 돋보기 제품목록 모달
	public List<OrdVO> prdList();
	
	// 돋보기 완제품LOT목록 모달
	public List<OrdVO> lotList();
	
	// 완제품LOT 재고 현황 모달
	public List<OrdVO> lotSList(OrdVO vo);
	
	// 완제품LOT 출고 현황 모달
	public List<OrdVO> lotOutList();
	
	// 주문서 관리 모달
	public List<OrdVO> ordList();
		
	
		
	/*-----------------
	// 	 주문 관리 Tab
	-------------------*/

	// 주문서 관리 리스트 조회 (단건, 조건조회)
	public List<OrdVO> getOrdList(OrdVO vo);
	
	// 주문서 관리 신규등록
	public int insertOrd(OrdVO vo);
	
	// 주문서 관리 수정
	public int updateOrd(OrdVO vo);
	
	// 주문서 관리 삭제
	public int deleteOrd(OrdVO vo);
	
	
	
	/*-----------------
	// 완제품 출고 조회 Tab
	-------------------*/
	
	// 출고 내역 리스트 조회
	public List<OrdVO> getOrdOutList(OrdVO vo);
	
	
	
	/*-----------------
	// 완제품 출고 관리 Tab
	-------------------*/
	
	// 진행중인 주문 리스트 조회
	public List<OrdVO> getIngOrdList(OrdVO vo);
	
	// 출고 등록 리스트 등록
	public int insertOutList(OrdVO vo);
	
	// 출고 등록 리스트 등록 후, 재고 업데이트
	public int updateOutList(OrdVO vo);
	
	// 출고 등록 리스트 등록 후, 주문서 진행상황 업데이트
	public int updateOrdStsList(OrdVO vo);
	
	
	/*-----------------
	// 완제품 반품 관리 Tab
	-------------------*/
	
	// 완제품 반품 관리 리스트 조회
	public List<OrdVO> getReList(OrdVO vo);

	// 완제품 반품 관리 리스트 등록
	public int insertReList(OrdVO vo);
	
	// 완제품 반품 관리 리스트 등록 후, 재고 업데이트
	public int updateReList(OrdVO vo);
	
	
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
	
	// 완제품 폐기 등록 현황 리스트 조회
	public List<OrdVO> getAgAmtList(OrdVO vo);
	
	// 완제품 폐기 리스트 등록
	public int insertEdateList(OrdVO vo);
	
	// 완제품 폐기 리스트 폐기 등록 후, 재고 수정
	public int updateEdateList(OrdVO vo);
	
	
	/*-----------------
	// 생산 요청 관리 Tab
	-------------------*/
	
	// 생산 요청 관리 리스트 조회
	public List<OrdVO> getPodList();
	
	// 생산 요청 관리 주문서 조건조회
	public List<OrdVO> getPodDetailList(OrdVO vo);
	
	// 생산 요청 관리 추가
	public int insertPodOrd(OrdVO vo);
	
	// 생산 요청 관리 수정
	public int updatePodOrd(OrdVO vo);
	
	// 생산 요청 관리 삭제
	public int deletePodOrd(OrdVO vo);
	
	
	
	/*-------------------
	// 제품 안전 재고 관리 Tab
	---------------------*/
	
	// 안전 재고 관리 리스트 조회
	public List<OrdVO> getSfamtList(OrdVO vo);
	
	
}
