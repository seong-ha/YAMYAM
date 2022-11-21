package com.mandu.yamyam.mat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandu.yamyam.mat.mapper.MatOdMapper;
import com.mandu.yamyam.mat.service.MatOdService;
import com.mandu.yamyam.mat.service.MatVO;

@Service
public class MatOdServiceImpl implements MatOdService {

	@Autowired
	MatOdMapper mapper;

	// 돋보기 자재목록 모달
	@Override
	public List<Map<String, Object>> matList() {
		return mapper.matList();
	}
	
	// 돋보기 업체목록 모달
	@Override
	public List<Map<String, Object>> actList() {
		return mapper.actList();
	}
	
	// 전체조회(일반 탭)
	@Override
	public List<Map<String, Object>> matOrderList() {
		return mapper.matOrderList();
	}

	// 자재 발주 관리 - 발주코드 단건 삭제(일반 탭)
	@Override
	public int delMatOd(MatVO vo) {
		return mapper.delMatOd(vo);
	}
	
	// 자재 발주 관리 - 발주코드 여러건 삭제(일반 탭)
	@Override
	public int delMatOdList(MatVO vo) {
		return mapper.delMatOdList(vo);
	}
	
	// 자재 발주 관리 - 발주상세코드 등록(일반 탭)
	@Override
	public int insMatOdList(MatVO vo) {
		return mapper.insMatOdList(vo);
	}

	// 신규생산계획조회(생산계획서용 탭)
	@Override
	public List<Map<String, Object>> newPlanList() {
		return mapper.newPlanList();
	}

	// 신규 생산 계획서 모델 선택 모달창(생산계획서용 탭)
	@Override
	public List<Map<String, Object>> addNewPlan() {
		return mapper.addNewPlan();
	}

	// 자재발주 전체리스트(생산계획서용 탭)
	@Override
	public List<Map<String, Object>> odMatList() {
		return mapper.odMatList();
	}

	// 신규생산계획 추가하면 리스트로.
	@Override
	public List<Map<String, Object>> newPlanInfo(MatVO vo) {
		return mapper.newPlanInfo(vo.getPplnCd());
	}

	// 필요자재조회(생산계획 탭)
	@Override
	public List<Map<String, Object>> needMatList(MatVO vo) {
		return mapper.needMatList(vo.getPrdCd());
	}

	// 자재발주 리스트(생산계획 탭)
	@Override
	public List<Map<String, Object>> chkMatList(MatVO vo) {
		return mapper.chkMatList(vo.getMtrCd());
	}

	// 발주 신청일 조회 버튼 클릭 이벤트 (자재 발주 조회 - 조건 조회 탭)
	@Override
	public List<Map<String, Object>> odListSearch(MatVO vo) {
		return mapper.odListSearch(vo);
	}

	// 자재 입고 검수 관리 - 추가 모달창
	@Override
	public List<Map<String, Object>> addChkModal() {
		return mapper.addChkModal();
	}

}
