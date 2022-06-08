package com.callor.app.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.app.model.RecallReturn;
import com.callor.app.model.RecallVO;
import com.callor.app.service.RecallService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value="/recall")
public class RecallController {

	
	
	private RecallService recallService;
	
	public RecallController(@Qualifier("recallServiceV3") RecallService recallService) {
		this.recallService = recallService;
	}
	
	@ResponseBody
	@RequestMapping(value={"/",""},method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<RecallVO>  home() {
		
		String queryString = recallService.queryString();
		
		RecallReturn recallReturn = recallService.getRecallList(queryString);
		List<RecallVO> recallList = recallReturn.content;
//		log.debug(recallList.toString());
//		log.debug()
		return recallList;
//		return "OK";
	}
	
	
	
	//TODO 리콜리스트
		@RequestMapping(value ="/recall_list", method = RequestMethod.GET)
		public String recall_list(Locale locale, Model model) {
			String queryString = recallService.queryString();
			RecallReturn recallReturn = recallService.getRecallList(queryString);
			List<RecallVO> recallList = recallReturn.content;

			model.addAttribute("RECALLS",recallList);
			model.addAttribute("TCOUNT",recallReturn.allCnt);
			return "/recall/recall_list";
		}
		
		//TODO 리콜 리스트 상세
		@RequestMapping(value ="/recall_detail", method = RequestMethod.GET)
		public String recall_datail(Locale locale, Model model) {
			String queryString = recallService.queryString();
			RecallReturn recallReturn = recallService.getRecallList(queryString);
			List<RecallVO> recallList = recallReturn.content;

			model.addAttribute("RECALLS",recallList);
			return "/recall/recall_detail";
		}
		
		/*
		 * recallSn 코드를 전달받아 한개의 리콜 정보만 json type 으로 보내기
		 * 실패
		 */
//		@ResponseBody
//		@RequestMapping(value = "/{recallSn}/recall",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//		public Object  (@PathVariable("recallSn") String isbn) {
//			 
//			String queryString = recallService.queryString("RECALLS",recallSn);
//			List<Object>  = recallService.getRecallList(queryString);
//			
//			return recallList.get(0);
//		}
}
