package com.mandu.yamyam.ord.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.ord.mapper.OrdMapper;
import com.mandu.yamyam.ord.service.OrdService;
import com.mandu.yamyam.ord.service.OrdVO;
@Service
public class OrdServiceImpl implements OrdService {

	@Autowired
	OrdMapper map;
	
	// 돋보기 업체목록 모달
	@Override
	public List<Map<String, Object>> actList() {
		return map.actList();
	}
	
	// 돋보기 제품목록 모달
	@Override
	public List<Map<String, Object>> prdList() {
		return map.prdList();
	}
	
	// 돋보기 완제품LOT목록 모달
	@Override
	public List<Map<String, Object>> lotList() {
		return map.lotList();
	}
	
	// 주문 관리 Tab
	
	// 주문서 관리 리스트 조회
	@Override
	public List<OrdVO> getOrdList() {
		return map.getOrdList();
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
	public int updateOrd(OrdVO vo) {
		return 0;
	}
	
	// 주문서 관리 삭제
	@Override
	public int deleteOrd(OrdVO vo) {
		return map.deleteOrd(vo);
	}


}
