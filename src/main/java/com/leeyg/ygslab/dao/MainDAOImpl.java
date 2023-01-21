package com.leeyg.ygslab.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.leeyg.ygslab.vo.AdminVO;
import com.leeyg.ygslab.vo.ITVO;
import com.leeyg.ygslab.vo.WritingVO;

@Repository
public class MainDAOImpl implements MainDAO {

	@Inject
	private SqlSession sql;
	private static String namespace = "com.leeyg.ygslab.mappers.main";
	
	@Override
	public List<WritingVO> mainPostList() throws Exception{
		return sql.selectList(namespace + ".mainPostList");
	}

	@Override
	public WritingVO writingDetail(int idx) throws Exception {
		return sql.selectOne(namespace + ".writingDetail", idx);
	}

	@Override
	public ITVO ITDetail(int idx) throws Exception {
		return sql.selectOne(namespace + ".ITDetail", idx);
	}

	
	@Override
	public List<WritingVO> writingList(int displayList) throws Exception {
		return sql.selectList(namespace + ".writingList", displayList);
	}

	@Override
	public List<ITVO> ITList(int displayList) throws Exception {
		return sql.selectList(namespace + ".ITList", displayList);
	}
	
	@Override
	public int writingListCnt() throws Exception {
		return sql.selectOne(namespace + ".writingListCnt");
	}
	
	@Override
	public int ITListCnt() throws Exception {
		return sql.selectOne(namespace + ".ITListCnt");
	}
	
	@Override
	public int loginAction(AdminVO adminVO) throws Exception {
		return sql.selectOne(namespace + ".loginAction", adminVO);
	}

	@Override
	public void writeWritingAction(WritingVO writing) throws Exception {
		sql.insert(namespace + ".writeWritingAction", writing);
	}
	
	@Override
	public void writeITAction(ITVO IT) throws Exception {
		sql.insert(namespace + ".writeITAction", IT);
	}

	@Override
	public int getWritingCurrentIdx() throws Exception {
		return sql.selectOne(namespace + ".getWritingCurrentIdx");
	}

	@Override
	public int getITCurrentIdx() throws Exception {
		return sql.selectOne(namespace + ".getITCurrentIdx");
	}
	
	@Override
	public List<WritingVO> modifyWritingList() throws Exception {
		return sql.selectList(namespace + ".modifyWritingList");
	}

	@Override
	public List<ITVO> modifyITList() throws Exception {
		return sql.selectList(namespace + ".modifyITList");
	}
	
	@Override
	public void modifyWritingAction(WritingVO writing) throws Exception {
		sql.update(namespace + ".modifyWritingAction", writing);
	}

	@Override
	public void modifyITAction(ITVO IT) throws Exception {
		sql.update(namespace + ".modifyITAction", IT);
	}
	
	@Override
	public void deleteWritingAction(int idx) throws Exception {
		sql.delete(namespace + ".deleteWritingAction", idx);
	}

	@Override
	public void deleteITAction(int idx) throws Exception {
		sql.delete(namespace + ".deleteITAction", idx);
	}
	
	@Override
	public void deleteWritingMoveIdx(int idx) throws Exception {
		sql.update(namespace + ".deleteWritingMoveIdx", idx);
	}

	@Override
	public void deleteITMoveIdx(int idx) throws Exception {
		sql.update(namespace + ".deleteITMoveIdx", idx);
	}
}
