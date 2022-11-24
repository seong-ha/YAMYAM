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
		
		
	/*-----------------
	// 	 주문 관리 Tab
	-------------------*/

	// 주문서 관리 리스트 조회
	public List<OrdVO> getOrdList();
	
	// 주문서 관리 주문서 조건조회
	public List<OrdVO> getList(OrdVO vo);
	
	// 주문서 관리 추가
	public int insertOrd(OrdVO vo);
	
	// 주문서 관리 수정
	public int updateOrd(OrdVO vo);
	
	// 주문서 관리 삭제
	public int deleteOrd(OrdVO vo);
	
	
	/*-----------------
	// 완제품 출고 조회 Tab
	-------------------*/
	
	// 출고 내역 리스트 조회
	public List<OrdVO> getOrdOutList();
	
	// 출고 내역 리스트 조건조회
	public List<OrdVO> getDetailOutList(OrdVO vo);
	
	// 출고중인 주문서 출고완료로 수정
	public int updateOutOrd(OrdVO vo);
}
