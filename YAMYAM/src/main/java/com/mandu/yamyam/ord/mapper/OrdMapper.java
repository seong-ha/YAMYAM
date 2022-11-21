package com.mandu.yamyam.ord.mapper;

import java.util.List;
import java.util.Map;

import com.mandu.yamyam.ord.service.OrdVO;

public interface OrdMapper {

	// 돋보기 업체목록 모달
	public List<Map<String, Object>> actList();
	
	// 돋보기 제품목록 모달
	public List<Map<String, Object>> prdList();
	
	// 돋보기 완제품LOT목록 모달
	public List<Map<String, Object>> lotList();
		
		
	// 주문 관리 Tab

	// 주문서 관리 리스트 조회
	public List<OrdVO> getOrdList();
	
	// 주문서 관리 추가
	public int insertOrd(OrdVO vo);
	
	// 주문서 관리 수정
	public int updateOrd(OrdVO vo);
	
	// 주문서 관리 삭제
	public int deleteOrd(OrdVO vo);
}
