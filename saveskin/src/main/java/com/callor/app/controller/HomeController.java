package com.callor.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.model.RecallReturn;
import com.callor.app.model.RecallVO;
import com.callor.app.service.RecallService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	private RecallService recallService;

	
	public HomeController(@Qualifier("recallServiceV3") RecallService recallService) {
		this.recallService = recallService;
	}
	
	//TODO 메인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		String queryString = recallService.queryString();
		RecallReturn recallReturn = recallService.getRecallList(queryString);
		List<RecallVO> recallList = recallReturn.content;

		model.addAttribute("RECALLS", recallList);
		
		return "home";
	}
	
	
}
