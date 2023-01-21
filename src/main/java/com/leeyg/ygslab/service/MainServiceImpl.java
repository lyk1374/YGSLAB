package com.leeyg.ygslab.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.leeyg.ygslab.dao.MainDAO;
import com.leeyg.ygslab.vo.AdminVO;
import com.leeyg.ygslab.vo.ITVO;
import com.leeyg.ygslab.vo.WritingVO;

@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDAO dao;
	
	@Override
	public List<WritingVO> mainPostList() throws Exception {
		return dao.mainPostList();
	}

	@Override
	public WritingVO writingDetail(int idx) throws Exception {
		return dao.writingDetail(idx);
	}

	@Override
	public ITVO ITDetail(int idx) throws Exception {
		return dao.ITDetail(idx);
	}
	
	@Override
	public List<WritingVO> writingList(int displayList) throws Exception {
		return dao.writingList(displayList);
	}

	@Override
	public List<ITVO> ITList(int displayList) throws Exception {
		return dao.ITList(displayList);
	}
	
	@Override
	public int writingListCnt() throws Exception {
		return dao.writingListCnt();
	}

	@Override
	public int ITListCnt() throws Exception {
		return dao.ITListCnt();
	}
	
	@Override
	public int loginAction(AdminVO adminVO) throws Exception {
		return dao.loginAction(adminVO);
	}

	@Override
	public void writeWritingAction(WritingVO writing) throws Exception {
		dao.writeWritingAction(writing);
	}

	@Override
	public void writeITAction(ITVO IT) throws Exception {
		dao.writeITAction(IT);
	}
	
	@Override
	public int getWritingCurrentIdx() throws Exception {
		return dao.getWritingCurrentIdx();
	}

	@Override
	public int getITCurrentIdx() throws Exception {
		return dao.getITCurrentIdx();
	}
	
	@Override
	public List<WritingVO> modifyWritingList() throws Exception {
		return dao.modifyWritingList();
	}
	
	@Override
	public List<ITVO> modifyITList() throws Exception {
		return dao.modifyITList();
	}

	@Override
	public void modifyWritingAction(WritingVO writing) throws Exception {
		dao.modifyWritingAction(writing);
	}

	@Override
	public void modifyITAction(ITVO IT) throws Exception {
		dao.modifyITAction(IT);
	}

	@Override
	public void deleteWritingAction(int idx) throws Exception{
		dao.deleteWritingAction(idx);
	}

	@Override
	public void deleteITAction(int idx) throws Exception{
		dao.deleteITAction(idx);
	}
	
	@Override
	public void deleteWritingMoveIdx(int idx, int listCnt) throws Exception {
		for(int i = idx + 1; i <= listCnt; i++) {
			dao.deleteWritingMoveIdx(i);
		}
	}
	
	@Override
	public void deleteITMoveIdx(int idx, int listCnt) throws Exception {
		for(int i = idx + 1; i <= listCnt; i++) {
			dao.deleteITMoveIdx(i);
		}
	}
	
}
