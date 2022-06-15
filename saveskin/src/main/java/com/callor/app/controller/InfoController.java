package com.callor.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.app.model.InfoParent;
import com.callor.app.model.InfoVO;
import com.callor.app.service.InfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/info")
public class InfoController {

	private InfoService infoService;

	public InfoController(InfoService infoService) {
		this.infoService = infoService;
	}

	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<InfoVO> home() {

		String queryString = infoService.queryString("10");

		InfoParent infoParent = infoService.getInfoList(queryString);
		List<InfoVO> infoList = infoParent.items;
		return infoList;

	}

	// TODO정보 리스트
	@RequestMapping(value = "/info_list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String info_list(String search, Model model) {
		
		log.debug("받은 검색어 {}", search);
		
		String queryString10 = infoService.queryString("10");
		InfoParent infoParent10 = infoService.getInfoList(queryString10);
		List<InfoVO> infoList10 = infoParent10.items;
		model.addAttribute("INFOS", infoList10);

		String queryString100 = infoService.queryString("100");
		InfoParent infoParent100 = infoService.getInfoList(queryString100);
		List<InfoVO> infoList100 = infoParent100.items;
		
		List<InfoVO> searchList = new ArrayList<>();
		if(search != null) {
			for(InfoVO vo : infoList100) {
				if(vo.getENTP_NAME().contains(search)) {
					log.debug("발견 {}", vo.getENTP_NAME());
					searchList.add(vo);
				} else if(!vo.getENTP_NAME().contains(search)) {
					log.debug("비었어 {} ", vo.getENTP_NAME());
					model.addAttribute("ERROR","FAIL");
				}
			}
			model.addAttribute("INFOS", searchList);
		}

		model.addAttribute("TCOUNT", infoParent100.totalCount);
		

		return "/info/info_list";
	}


	// TODO정보 리스트 상세
	@RequestMapping(value = "/{ENTP_SEQ}/info_detail", method = RequestMethod.GET)
	public String info_detail(@PathVariable("ENTP_SEQ") String ENTP_SEQ, Model model) {
		String queryString = infoService.queryString("10");
		InfoParent infoParent = infoService.getInfoList(queryString);
		List<InfoVO> infoList = infoParent.items;
		InfoVO vo = null;
		for (InfoVO VV : infoList) {
			if (VV.getENTP_SEQ().equals(ENTP_SEQ)) {
				vo = VV;
				break;
			}
		}
		model.addAttribute("INFO", vo);

		return "/info/info_detail";
	}
}
