package com.callor.app.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/info")
public class InfoController {
	


	//TODO 화장품 정보 리스트
	@RequestMapping(value = "/info_list", method = RequestMethod.GET)
	public String info_list(Locale locale, Model model) {
		
		return "/info/info_list";
	}
	
	//TODO 화장품 정보 리스트 상세
	@RequestMapping(value = "/info_detail", method = RequestMethod.GET)
	public String info_detail(Locale locale, Model model) {
		
		return "/info/info_detail";
	}
}
