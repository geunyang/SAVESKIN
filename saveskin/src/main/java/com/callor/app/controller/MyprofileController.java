package com.callor.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.app.model.UserVO;
import com.callor.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/myprofile")
public class MyprofileController {

	private final UserService userService;

	public MyprofileController(UserService userService) {
		this.userService = userService;
	}

	// TODO 내 상세정보가기
	@RequestMapping(value = "/myprofile", method = RequestMethod.GET)
	public String myprofile(HttpSession session, Model model) {

		// TODO 세션값을 컨트롤러로 어떻게 가져와야하는가??
		if (session.getAttribute("USER") != null) {
			UserVO userVO = (UserVO) session.getAttribute("USER");
			model.addAttribute("INFO",userVO);
			return "/myprofile/myprofile";
		}
		return "/user/user_login";
	}
	
	// TODO 상세정보에서 로그인
		@RequestMapping(value = "/myprofile", method = RequestMethod.POST)
		public String myprofile(UserVO userVO,HttpSession session) {

			String loginMessage = null;
			UserVO loginUserVO = userService.findById(userVO.getUserid());
			
			if(loginMessage == null) {
				session.setAttribute("USER", loginUserVO);
			}
			return "redirect:/myprofile/myprofile";
		}
		
		
	//TODO 개인정보 수정페이지 가기
	@RequestMapping(value = "/myprofile-update", method = RequestMethod.GET)
	public String userInfoUpdate() {
		return "/myprofile/myprofile-update";
	}
	
	//TODO 개인정보 수정 입력받기
		@RequestMapping(value = "/myprofile-update", method = RequestMethod.POST)
		public String userInfoUpdate(UserVO userVO, Model model) {
			userService.update(userVO);
			
			model.addAttribute("INFO", userVO);
			return "/myprofile/myprofile";

		}

	// TODO 닉네임 중복검사
	@ResponseBody
	@RequestMapping(value = "/namecheck/{username}", method = RequestMethod.GET)
	public String namecheck(@PathVariable String username) {
		UserVO userVO = userService.findByName(username);
		if (userVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}

	}
}
