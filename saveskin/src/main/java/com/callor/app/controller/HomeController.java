package com.callor.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.model.BoardVO;
import com.callor.app.model.InfoParent;
import com.callor.app.model.InfoVO;
import com.callor.app.model.RecallReturn;
import com.callor.app.model.RecallVO;
import com.callor.app.service.BoardService;
import com.callor.app.service.InfoService;
import com.callor.app.service.RecallService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	private RecallService recallService;
	@Autowired
	private InfoService infoService;
	@Autowired
	private BoardService boardSservice;

	
	public HomeController(@Qualifier("recallServiceV3") RecallService recallService) {
		this.recallService = recallService;
	}
	
	//TODO 메인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//리콜정보 리스트
		String queryString5 = recallService.queryString(5);
		RecallReturn recallReturn5 = recallService.getRecallList(queryString5);
		List<RecallVO> recallList5 = recallReturn5.content;
		model.addAttribute("RECALLS", recallList5);	
		
		String infoString5 = infoService.queryString("5");
		InfoParent infoParent5 = infoService.getInfoList(infoString5);
		List<InfoVO> infoList5 = infoParent5.items;
		model.addAttribute("INFOLIST", infoList5);
		
		
		//게시판 리스트
		List<BoardVO> boardList =  boardSservice.selectAll();
		model.addAttribute("BOARDLIST", boardList);
		
		
		
		return "home";
	}
	
	
}
