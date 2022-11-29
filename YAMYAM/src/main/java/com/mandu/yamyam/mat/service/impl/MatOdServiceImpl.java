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
	
	//===============================================
	// 자재 발주 조회
	//===============================================
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
	
	//===============================================
	// 1) 자재 발주 관리
	//===============================================
	// 자재 발주 관리(일반 탭) - 기본 전체 조회
	@Override
	public List<Map<String, Object>> matOderN7() {
		return mapper.matOderN7();
	}
	
	// 조회 버튼 클릭 시 전체조회(일반 탭)
	@Override
	public List<Map<String, Object>> matOrderList(MatVO vo) {
		return mapper.matOrderList(vo);
	}

	// 자재 발주 관리 - 발주코드 단건 삭제(일반 탭)
	@Override
	public int delMatOd(MatVO vo) {
		return mapper.delMatOd(vo);
	}
	
	// 자재 발주 관리 - 발주코드 여러건 삭제(일반 탭)
	@Override
	public int delMatOdList(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.delMatOdList(list.get(i));
		}
		return result;
	}
	
	// 자재 발주 관리 - 발주상세코드 여러건 삭제(일반 탭)
	@Override
	public int delMatOddList(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.delMatOddList(list.get(i));
		}
		return result;
	}
	
	// 자재 발주 관리 - 발주상세코드 등록(일반 탭)
	@Override
	public int insMatOdList(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.insMatOdList(list.get(i));
		}
		return result;
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
	
	// 생산계획 모달창 탭 날짜 조회 버튼(생산계획용 탭)
	@Override
	public List<Map<String, Object>> newPlanLookUpBtn(MatVO vo) {
		return mapper.newPlanLookUpBtn(vo);
	}
	
	// 발주 리스트 날짜 조회버튼(일반 탭)
	@Override
	public List<Map<String, Object>> odListDtLookUpBtn(MatVO vo) {
		return mapper.odListDtLookUpBtn(vo);
	}

	@Override
	public int updatePlndSts(MatVO vo) {
		return mapper.updatePlndSts(vo);
	}
	
	//===============================================
	// 2) 자재 발주 조회
	//===============================================
	// 자재 발주 전체 조회
	@Override
	public List<Map<String, Object>> matOdLookUpList() {
		return mapper.matOdLookUpList();
	}
	
	// 발주 신청일 조회 버튼 클릭 이벤트 (자재 발주 조회 - 조건 조회 탭)
	@Override
	public List<Map<String, Object>> odListSearch(MatVO vo) {
		return mapper.odListSearch(vo);
	}

	// 발주 신청일 클릭 시 이벤트 (조건 조회 탭)
	@Override
	public List<Map<String, Object>> clickOdDate(MatVO vo) {
		return mapper.clickOdDate(vo);
	}

	//===============================================
	// 3) 자재 입고 검수 관리
	//===============================================
	// 자재 발주 7일치 기본 조회
	@Override
	public List<Map<String, Object>> chkOdList7() {
		return mapper.chkOdList7();
	}
	
	// 자재 입고 검수 관리 - 추가 모달창
	@Override
	public List<Map<String, Object>> addChkModal() {
		return mapper.addChkModal();
	}

	// 자재 입고 검수 관리 - 전체 조회
	@Override
	public List<Map<String, Object>> chkOdMatList(MatVO vo) {
		return mapper.chkOdMatList(vo);
	}

	// 불량코드/불량내용 조회
	@Override
	public List<Map<String, Object>> erCdErInfoLookUp() {
		return mapper.erCdErInfoLookUp();
	}

	// 자재 입고 검수 관리 - insert
	@Override
	public int insertChkOd(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.insertChkOd(list.get(i));
		}
		return result;
	}
	
	// 자재 입고 검수 관리 - update
	@Override
	public int updateMatOdSts(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.updateMatOdSts(list.get(i));
		}
		return result;
	}
	
	// 자재 입고 검수 관리 - delete
	@Override
	public int deletetChkOd(List<MatVO> list) {
		int result = 0;
		   for(int i=0; i<list.size(); i++) {
			   result += mapper.deletetChkOd(list.get(i));
		   }
		return result;
	}

	// 직원 목록 조회 모달
	@Override
	public List<Map<String, Object>> empLookUp() {
		return mapper.empLookUp();
	}

	//===============================================
	// 4) 자재 입고 관리
	//===============================================
	// 조회 버튼 조회
	@Override
	public List<Map<String, Object>> matInAllList(MatVO vo) {
		return mapper.matInAllList(vo);
	}
	
	// 기본 조회
	@Override
	public List<Map<String, Object>> matInList() {
		return mapper.matInList();
	}

	// 입고 예정 목록
	@Override
	public List<Map<String, Object>> beforeInList() {
		return mapper.beforeInList();
	}

	// insert
	@Override
	public int inManageSave(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.inManageSave(list.get(i));
		}
		return result;
	}
	
	// update
	@Override
	public int updateMatInsts(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.updateMatInsts(list.get(i));
		}
		
		return result;
	}

	// delete
	@Override
	public int inManageDelete(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.inManageDelete(list.get(i));
		}
		return result;
	}

	//===============================================
	// 5) 자재 출고 관리
	//===============================================
	// 생산 지시 조회
	@Override
	public List<Map<String, Object>> pOdAllList() {
		return mapper.pOdAllList();
	}

	// 필요자재
	@Override
	public List<Map<String, Object>> needMtrList(MatVO vo) {
		return mapper.needMtrList(vo);
	}
	
	// 필요자재LOT목록
	@Override
	public List<Map<String, Object>> needMtrLotList(MatVO vo) {
		return mapper.needMtrLotList(vo);
	}

	// 출고테이블로 insert
	@Override
	public int insertMatOut(List<MatVO> list) {
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			result += mapper.insertMatOut(list.get(i));
		}
		return result;
	}
	
	// 출고처리 - 자재 마이너스 업데이트
	@Override
	public int updateOutOd(List<MatVO> list) {
		int result = 0;
		
		for(int i=0; i<list.size(); i++) {
		 result += mapper.updateOutOd(list.get(i));
		}
		return result;
	}

	// 출고처리 - 상태 완료로 업데이트
	@Override
	public int updateOutSts(MatVO vo) {
		return mapper.updateOutSts(vo);
	}

	//===============================================
	// 6) 자재 입출고 조회
	//===============================================
	// 입고 전체조회
	@Override
	public List<Map<String, Object>> inOutAllList() {
		return mapper.inOutAllList();
	}
	
	// 입고 전체조회
	@Override
	public List<Map<String, Object>> outInAllList() {
		return mapper.outInAllList();
	}

	// 입고 조건조회
	@Override
	public List<Map<String, Object>> selectInOutAllList(MatVO vo) {
		return mapper.selectInOutAllList(vo);
	}

	// 출고 조건조회
	@Override
	public List<Map<String, Object>> selectOutInAllList(MatVO vo) {
		return mapper.selectOutInAllList(vo);
	}
	
	//===============================================
	// 7) 자재 재고 조회
	//===============================================
	// 전체조회
	@Override
	public List<Map<String, Object>> matStockList() {
		return mapper.matStockList();
	}

	@Override
	public List<Map<String, Object>> getHoldAmt() {
		return mapper.getHoldAmt();
	}

	@Override
	public List<Map<String, Object>> matStockSelectList(MatVO vo) {
		return mapper.matStockSelectList(vo);
	}

	//===============================================
	// 8) 자재 반품 관리
	//===============================================
	//  전체리스트 상세정보
	@Override
	public List<Map<String, Object>> returnInfo(MatVO vo) {
		return mapper.returnInfo(vo);
	}

	// 반품 리스트
	@Override
	public List<Map<String, Object>> returnMtrList() {
		return mapper.returnMtrList();
	}

	// insert
	@Override
	public int insertRtOd(MatVO vo) {
		return mapper.insertRtOd(vo);
	}
	
	// update
	@Override
	public int updateRtOd(MatVO vo) {
		return mapper.updateRtOd(vo);
	}
	//===============================================
	// 9) 자재 반품 조회
	//===============================================
	// 전체리스트
	@Override
	public List<Map<String, Object>> mtrReturnAllList() {
		return mapper.mtrReturnAllList();
	}

	// 조건조회
	@Override
	public List<Map<String, Object>> matReturnSearch(MatVO vo) {
		return mapper.matReturnSearch(vo);
	}

	@Override
	public int mtrSfUpdate(MatVO vo) {
		return mapper.mtrSfUpdate(vo);
	}

}
