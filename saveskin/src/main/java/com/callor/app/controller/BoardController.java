package com.callor.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.model.BoardVO;
import com.callor.app.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value={"/",""})
	public String home() {
		/*
		 * return "문자열" 형식은
		 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지
		 * 알려주는 것이다.
		 * 현재 method를 요청한 URL에 대하여 jsp을 
		 * 명시적으로 전달한다.
		 */
		return "redirect:/board/board_list";
	}
	
	//TODO 자유게시판 리스트
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public String board_list(Model model) {
		
		List<BoardVO> boardList = boardService.selectAll();
		
		model.addAttribute("board", boardList);
		
		return "/board/board_list";
	}
	
	//TODO 자유게시판 글 쓰기
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write( ) {
		
		
		
		return "/board/board_write";
	}
	
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardVO boardvo) {
		log.debug("확인ㅇㅇ"+ boardvo.toString());
		boardService.insert(boardvo);
		
		
		return "redirect:/board/board_list";
	}
		
	
	//TODO 자유게시판 상세페이지
	@RequestMapping(value="{b_num}/board_detail", method=RequestMethod.GET)
	public String board_detail(@PathVariable("b_num") String b_num, Model model) {
		
		BoardVO boardVO = boardService.findByNumber(b_num);
		model.addAttribute("BOARD", boardVO);
		return "board/board_detail";
	}

}
