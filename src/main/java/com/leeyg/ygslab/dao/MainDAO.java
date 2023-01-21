package com.leeyg.ygslab.dao;

import java.util.List;

import com.leeyg.ygslab.vo.AdminVO;
import com.leeyg.ygslab.vo.ITVO;
import com.leeyg.ygslab.vo.WritingVO;

public interface MainDAO {
	
	public List<WritingVO> mainPostList() throws Exception;
	
	public WritingVO writingDetail(int idx) throws Exception;
	
	public ITVO ITDetail(int idx) throws Exception;

	public List<WritingVO> writingList(int displayList) throws Exception;
	
	public List<ITVO> ITList(int displayList) throws Exception;
	
	public int writingListCnt() throws Exception;

	public int ITListCnt() throws Exception;
	
	public int loginAction(AdminVO adminVO) throws Exception;
	
	public void writeWritingAction(WritingVO writing) throws Exception;
	
	public void writeITAction(ITVO IT) throws Exception;
	
	public int getWritingCurrentIdx() throws Exception;
	
	public int getITCurrentIdx() throws Exception;
	
	public List<WritingVO> modifyWritingList() throws Exception;
	
	public List<ITVO> modifyITList() throws Exception;
	
	public void modifyWritingAction(WritingVO writing) throws Exception;
	
	public void modifyITAction(ITVO IT) throws Exception;
	
	public void deleteWritingAction(int idx) throws Exception;

	public void deleteITAction(int idx) throws Exception;
	
	public void deleteWritingMoveIdx(int idx) throws Exception;
	
	public void deleteITMoveIdx(int idx) throws Exception;
}
