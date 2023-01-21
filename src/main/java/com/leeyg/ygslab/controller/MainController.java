package com.leeyg.ygslab.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leeyg.ygslab.service.MainService;
import com.leeyg.ygslab.vo.AdminVO;
import com.leeyg.ygslab.vo.ITVO;
import com.leeyg.ygslab.vo.WritingVO;

@Controller
public class MainController {
	
	@Inject
	private MainService service;
	
	@RequestMapping(value = "/main.do")
	public String main(Model model) {
		
		List<WritingVO> list = null;
		try {
			list = service.mainPostList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("list", list);
		
		return "main";
	}
	
	@RequestMapping(value = "/writing.do")
	public String writing(Model model, @RequestParam int idx) {
		
		WritingVO writing = null;
		WritingVO prevWriting = null;
		WritingVO nextWriting = null;
		int listCnt = 0;
		try {
			writing = service.writingDetail(idx);
			if(idx != 1) {
				prevWriting = service.writingDetail(idx - 1);
			}
			listCnt = service.writingListCnt();
			if(idx != listCnt) {
				nextWriting = service.writingDetail(idx + 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		int curPageNum = (listCnt - idx) / 10 + 1;
		
		model.addAttribute("writing", writing);
		model.addAttribute("prevWriting", prevWriting);
		model.addAttribute("nextWriting", nextWriting);
		model.addAttribute("curPageNum", curPageNum);
		
		return "writing";
	}
	
	@RequestMapping(value = "/IT.do")
	public String IT(Model model, @RequestParam int idx) {
		
		ITVO IT = null;
		ITVO prevIT = null;
		ITVO nextIT = null;
		int listCnt = 0;
		try {
			IT = service.ITDetail(idx);
			if(idx != 1) {
				prevIT = service.ITDetail(idx - 1);
			}
			listCnt = service.ITListCnt();
			if(idx != listCnt) {
				nextIT = service.ITDetail(idx + 1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		int curPageNum = (listCnt - idx) / 10 + 1;
		
		model.addAttribute("IT", IT);
		model.addAttribute("prevIT", prevIT);
		model.addAttribute("nextIT", nextIT);
		model.addAttribute("curPageNum", curPageNum);
		
		return "IT";
	}
	
	@RequestMapping(value = "/writingList.do")
	public String writingList(Model model, @RequestParam("curPageNum") int curPageNum) {
		
		List<WritingVO> list = null;
		int listCnt = 0;
		int displayList = (curPageNum - 1) * 10;
		try {
			listCnt = service.writingListCnt();
			list = service.writingList(displayList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int allPageCnt = (int)Math.ceil((double)listCnt / 10);
		int startPageNum = 0;
		int endPageNum = 0;
		
		if(curPageNum - 2 > 1) {
			startPageNum = curPageNum - 2;
		}else {
			startPageNum = 1;
		}
		
		if(curPageNum + 2 < allPageCnt) {
			endPageNum = curPageNum + 2;
		}else {
			endPageNum = allPageCnt;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curPageNum", curPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("allPageCnt", allPageCnt);
		
		return "writingList";
	}
	
	@RequestMapping(value = "/ITList.do")
	public String ITList(Model model, @RequestParam("curPageNum") int curPageNum) {
		
		List<ITVO> list = null;
		int listCnt = 0;
		int displayList = (curPageNum - 1) * 10;
		try {
			listCnt = service.ITListCnt();
			list = service.ITList(displayList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int allPageCnt = (int)Math.ceil((double)listCnt / 10);
		int startPageNum = 0;
		int endPageNum = 0;
		
		if(curPageNum - 2 > 1) {
			startPageNum = curPageNum - 2;
		}else {
			startPageNum = 1;
		}
		
		if(curPageNum + 2 < allPageCnt) {
			endPageNum = curPageNum + 2;
		}else {
			endPageNum = allPageCnt;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curPageNum", curPageNum);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		model.addAttribute("allPageCnt", allPageCnt);
		
		return "ITList";
	}
	
	@RequestMapping(value = "/adminLogin.do")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@RequestMapping(value = "/loginAction.do")
	public String loginAction(@RequestParam String id, @RequestParam String pw) {
		int loginChk = 0;
		AdminVO adminVO = new AdminVO();
		adminVO.setAdmin_id(id);
		adminVO.setAdmin_pw(pw);
		try {
			loginChk = service.loginAction(adminVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(loginChk == 1) {
			return "adminPage";
		}else {
			return "loginFailPage";
		}
	}
	
	@RequestMapping(value = "write.do")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "/writeAction.do")
	public String writeAction(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writeType = req.getParameter("writeType");
		WritingVO writing = new WritingVO();
		ITVO IT = new ITVO();
		
		if(writeType.equals("writing")) {
			try {
				writing.setWriting_idx(service.getWritingCurrentIdx() + 1);
				writing.setWriting_title(title);
				writing.setWriting_content(content);
				service.writeWritingAction(writing);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(writeType.equals("IT")) {
			try {
				IT.setIt_idx(service.getITCurrentIdx() + 1);
				IT.setIt_title(title);
				IT.setIt_content(content);
				service.writeITAction(IT);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return "adminPage";
	}
	
	@RequestMapping(value = "/modifyList.do")
	public String modifyList(Model model) {
		List<WritingVO> writingList = null;
		List<ITVO> ITList = null;
		
		try {
			writingList = service.modifyWritingList();
			ITList = service.modifyITList();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("writingList", writingList);
		model.addAttribute("ITList", ITList);
		
		return "modifyList";
	}
	
	@RequestMapping(value = "/writingModify.do")
	public String writingModify(@RequestParam int idx, Model model) {
		WritingVO writing = null;
		try {
			writing = service.writingDetail(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("writing", writing);
		
		return "writingModify";
	}
	
	@RequestMapping(value = "/ITModify.do")
	public String ITModify(@RequestParam int idx, Model model) {
		ITVO IT = null;
		try {
			IT = service.ITDetail(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("IT", IT);
		
		return "ITModify";
	}
	
	@RequestMapping(value = "/modifyAction.do")
	public String modifyAction(HttpServletRequest req) {
		int idx = Integer.parseInt(req.getParameter("idx"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writeType = req.getParameter("writeType");
		WritingVO writing = new WritingVO();
		ITVO IT = new ITVO();
		
		if(writeType.equals("writing")) {
			try {
				writing.setWriting_idx(idx);
				writing.setWriting_title(title);
				writing.setWriting_content(content);
				service.modifyWritingAction(writing);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else if(writeType.equals("IT")) {
			try {
				IT.setIt_idx(idx);
				IT.setIt_title(title);
				IT.setIt_content(content);
				service.modifyITAction(IT);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return "adminPage";
	}
	
	@RequestMapping(value = "/deleteList.do")
	public String deleteList(Model model) {
		List<WritingVO> writingList = null;
		List<ITVO> ITList = null;
		
		try {
			writingList = service.modifyWritingList();
			ITList = service.modifyITList();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("writingList", writingList);
		model.addAttribute("ITList", ITList);
		
		return "deleteList";
	}
	
	@RequestMapping(value = "/deleteWritingAction.do")
	public String deleteWritingAction(@RequestParam int idx) {
		int listCnt = 0;
		
		try {
			listCnt = service.writingListCnt();
			service.deleteWritingAction(idx);
			service.deleteWritingMoveIdx(idx, listCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "adminPage";
	}
	
	@RequestMapping(value = "/deleteITAction.do")
	public String deleteITAction(@RequestParam int idx) {
		int listCnt = 0;
		
		try {
			listCnt = service.ITListCnt();
			service.deleteITAction(idx);
			service.deleteITMoveIdx(idx, listCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "adminPage";
	}
}
