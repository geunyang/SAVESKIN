package com.callor.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.model.BoardVO;
import com.callor.app.model.UserVO;
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
	public String board_list(Model model, HttpSession session) {
		
		session.getAttribute("USER");
		List<BoardVO> boardList = boardService.selectAll();
		
		model.addAttribute("board", boardList);
		
		return "/board/board_list";
	}
	
	//TODO 자유게시판 글 쓰기
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write(Model model, HttpSession session) {
		
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		
		UserVO loginUser = (UserVO)session.getAttribute("USER");
		
		
		BoardVO boardVO = BoardVO.builder()
				.b_date(dayFormat.format(date))
				.b_time(timeFormat.format(date))
				.b_writer(loginUser.getUsername())
				.build();
		model.addAttribute("board", boardVO);
		
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
	public String board_detail(@PathVariable("b_num") int b_num, Model model, HttpSession session) {
		
		UserVO userVO = (UserVO)session.getAttribute("USER");
		BoardVO boardVO = boardService.findByNumber(b_num);
		model.addAttribute("BOARD", boardVO);
	// model.addAttribute("USERNAME", userVO.getUsername());
		
		try {
			if(boardVO.getB_writer().equals(userVO.getUsername())) {
				model.addAttribute("USER1","OK");
			} else {
			}
			log.debug( userVO.getUsername());
			log.debug( boardVO.getB_writer());
		} catch (Exception e) {
		}
		
		return "board/board_detail";
	}

	//TODO 자유게시판 수정..
	@RequestMapping(value="{b_num}/board_update", method=RequestMethod.GET)
	public String board_update(@PathVariable("b_num") int b_num, Model model, HttpSession session) {
		
		UserVO loginUser = (UserVO)session.getAttribute("USER");
		BoardVO boardVO = boardService.findByNumber(b_num);
		
		model.addAttribute("board", boardVO);
		
		return "/board/board_write";
	}	
	
	@RequestMapping(value="{b_num}/board_update", method=RequestMethod.POST)
	public String board_update(BoardVO boardVO, Model model, HttpSession session) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		
		UserVO loginUser = (UserVO)session.getAttribute("USER");

		if(loginUser == null) {
			return "redirect:/user/user_login";
		}
		
//		BoardVO boardVO1 = BoardVO.builder()
//				.b_date(dayFormat.format(date))
//				.b_time(timeFormat.format(date))
//				.b_writer(loginUser.getUsername())
//				.b_title(boardVO.getB_title())
//				.build();
		
		log.debug("=".repeat(100));
		log.debug(boardVO.getB_title());
		
		boardVO.setB_date(dayFormat.format(date));
		boardVO.setB_time(timeFormat.format(date));
		boardService.update(boardVO);
		
		// boardService.insert(boardVO);
		
		 model.addAttribute("board", boardVO);
		
		String retStr = String.format("redirect:/board/%s/board_detail", boardVO.getB_num());
		return retStr;
		
	}	
	
	// 자유게시판 글 삭제
	@RequestMapping(value="/{b_num}/board_delete", method=RequestMethod.GET)
	public String delete(@PathVariable("b_num") String b_num) {
		
		int ret = boardService.deleteByNum(b_num);
		// 삭제한 데이터 개수를 return 한다
		// int ret = BoardService.delete(b_num);
		
		return "redirect:/board/board_list";
	}
	
}
