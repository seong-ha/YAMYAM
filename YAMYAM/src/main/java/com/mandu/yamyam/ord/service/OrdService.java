package com.mandu.yamyam.ord.service;

import java.util.List;

public interface OrdService {

	// 돋보기 업체목록 모달
	public List<OrdVO> actList();
	
	// 돋보기 제품목록 모달
	public List<OrdVO> prdList();
	
	// 돋보기 완제품LOT목록 모달
	public List<OrdVO> lotList();
	
	
	// 주문 관리 Tab
	
	// 주문서 관리 리스트 조회
	public List<OrdVO> getOrdList();
	
	// 주문서 관리 주문서 조건조회
	public List<OrdVO> getList(OrdVO vo);
	
	// 주문서 관리 추가
	public int insertOrd(List<OrdVO> vo);
	
	// 주문서 관리 수정
	public int updateOrd(List<OrdVO> vo);
	
	// 주문서 관리 삭제
	public int deleteOrd(OrdVO vo);
}
