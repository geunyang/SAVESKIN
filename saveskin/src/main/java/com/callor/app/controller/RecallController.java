package com.callor.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.app.model.InfoVO;
import com.callor.app.model.RecallReturn;
import com.callor.app.model.RecallVO;
import com.callor.app.service.RecallService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/recall")
public class RecallController {

	private RecallService recallService;

	public RecallController(@Qualifier("recallServiceV3") RecallService recallService) {
		this.recallService = recallService;
	}

	@ResponseBody
	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<RecallVO> home() {

		String queryString = recallService.queryString(10);

		RecallReturn recallReturn = recallService.getRecallList(queryString);
		List<RecallVO> recallList = recallReturn.content;
//		log.debug(recallList.toString());
//		log.debug()
		return recallList;
//		return "OK";
	}

	// TODO 리콜리스트
	@RequestMapping(value = "/recall_list", method = RequestMethod.GET)
	public String recall_list(String search, Model model) {
		
		log.debug("받은 검색어 {}",  search);
		
		String queryString10 = recallService.queryString(10);
		RecallReturn recallReturn10 = recallService.getRecallList(queryString10);
		List<RecallVO> recallList10 = recallReturn10.content;

		model.addAttribute("RECALLS", recallList10);
		
		String queryString100 = recallService.queryString(100);
		RecallReturn recallReturn100 = recallService.getRecallList(queryString100);
		List<RecallVO> recallList100 = recallReturn100.content;

		List<RecallVO> searchList = new ArrayList<>();
//		if(search != null) {
//			for(RecallVO vo : recallList100 ) {
//				if(vo.getProductNm().contains(search)) {
//					log.debug("찾았어 {}", vo.getProductNm());
//					searchList.add(vo);
//				} else if(!vo.getProductNm().contains(search)) {
//					log.debug("비었어 {}", vo.getProductNm());
//					
//					model.addAttribute("ERROR","FAIL");
//				}
//					
//			}
//			model.addAttribute("RECALLS",searchList);
//			
//		}
		if (search != null) {
			for (RecallVO vo : recallList100) {
				if (vo.getProductNm().contains(search)) {
					searchList.add(vo);
				}
			}
			if (searchList.size() <1) {
				model.addAttribute("ERROR","FAIL");
			}
			model.addAttribute("RECALLS", searchList);
		}
		
		model.addAttribute("TCOUNT", recallReturn100.allCnt);
		
		return "/recall/recall_list";
	}

	// TODO 리콜 리스트 상세
//	@RequestMapping(value = "/recall_detail", method = RequestMethod.GET)
//	public String recall_datail(Locale locale, Model model) {
//		String queryString = recallService.queryString();
//		RecallReturn recallReturn = recallService.getRecallList(queryString);
//		List<RecallVO> recallList = recallReturn.content;
//
//		model.addAttribute("RECALLS", recallList);
//		return "/recall/recall_detail";
//	}

	
	@RequestMapping(value="/{recallSn}/recall_detail",method=RequestMethod.GET)
	public String detail(@PathVariable("recallSn") String recallSn, Model model) {
		
		
		String queryString = recallService.queryString(100);
		RecallReturn recallReturn = recallService.getRecallList(queryString);
		List<RecallVO> recallList = recallReturn.content;
		
		RecallVO vo = null;
		for(RecallVO VV : recallList) {
			if(VV.getRecallSn().equals(recallSn)) {
				vo = VV;
				break;
			}
			
		}
		log.debug("실험결과 : " + vo);
		model.addAttribute("RECALL", vo);
		
		return "/recall/recall_detail";
	}
	/*
	 * recallSn 코드를 전달받아 한개의 리콜 정보만 json type 으로 보내기 실패
	 */
//	@RequestMapping(value = "/{seq}/{nm}/detail", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//		public String detail(@PathVariable("nm") String nm, @PathVariable("seq")  String seq, Model model) {
//
//			
//		/*
//		 * String queryString = naver.queryString("LIST", isbn);
//		 * String queryString = naver.queryString("DETAIL", isbn);
//		 * 
//		 * 이렇게 해서 두 경우로 나누자!
//		 * NaverServiceImplV1 getNaver 참고 !!
//		 */
//			String quString = post.queryString("LIST", nm);
//			List<DosungPostVO> recipeList = post.getRecipes(quString);
//			List<DosungDetailVO> detailList = post.getDetail(quString);
//			
//			DosungPostVO postVO = null;
//			for(DosungPostVO dVO : recipeList) {
//				if(dVO.getRCP_SEQ().equals(seq)){
//					postVO = dVO;
//					break;
//				}
//			}
//			DosungDetailVO dVO  = null;
//			dVO = detailList.get(0);
//			log.debug("디테일브이오" + dVO.toString());
//		
//			model.addAttribute("RECIPE", postVO);
//			model.addAttribute("DETAIL",dVO);
//
//
//			
//			return "recall/recall_detail";
//			
//		}
}
