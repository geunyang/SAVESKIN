package com.callor.app.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value="/recall")
public class RecallController {

	
	//TODO 리콜리스트
		@RequestMapping(value ="/recall_list", method = RequestMethod.GET)
		public String recall_list(Locale locale, Model model) {
			
			return "/recall/recall_list";
		}
		
		//TODO 리콜 리스트 상세
		@RequestMapping(value ="/recall_detail", method = RequestMethod.GET)
		public String recall_datail(Locale locale, Model model) {
			
			return "/recall/recall_detail";
		}
}
