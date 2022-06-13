package com.callor.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	public String board_list(HttpSession session) {

		// TODO 세션값을 컨트롤러로 어떻게 가져와야하는가??
		if (session.getAttribute("USER") == "USER") {
			return "redirect:/user/user_login";
		}
		return "/myprofile/myprofile";
	}

	@RequestMapping(value = "/myprofile-update", method = RequestMethod.GET)
	public String userInfoUpdate() {
		return "/myprofile/myprofile-update";

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
