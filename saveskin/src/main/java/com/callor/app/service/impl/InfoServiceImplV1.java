package com.callor.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.callor.app.config.InfoAPIConfig;
import com.callor.app.model.InfoVO;
import com.callor.app.service.InfoService;

public class InfoServiceImplV1 implements InfoService{

	@Override
	public String queryString() {
		
		String queryString = InfoAPIConfig.URL;
		
		queryString += "?serviceKey=%s";
		queryString += "&numOfRows=%d";
		queryString += "&pageNo=%d";
		queryString += "&type=%s";
		
		return String.format(queryString, InfoAPIConfig.SERVICE_KEY,1,10,"json");
	}
	
	public String getJsonString(String queryString) {
		
		// java.net.URL 을 import
		URL url = null;
		HttpURLConnection httpCon = null;
		
		// queryString(URL, 요청정보)를 사용하여
		// Network 통해서 보낼 데이터로 생성하기
		try {
			url = new URL(queryString);
			httpCon = (HttpURLConnection) url.openConnection();
			
			// get 방식으로 요청(주소창에보이게)
			httpCon.setRequestMethod("GET");
			//220609여기까지수정
			
			// 문자열 오류 많이나서 변수에 담아버림
			// httpCon.setRequestProperty("X-Naver-Client_Id", NAVER_CLIENT_ID);			
			httpCon.setRequestProperty();
			httpCon.setRequestProperty();
			
			// Naver 에게 queryString 정보를 보내고
			// response 해줄 데이터가 있는지 먼저 확인
			
			int resCode = httpCon.getResponseCode();
			
			InputStreamReader is = null;
			BufferedReader buffer = null;
			
			// Naver 가 200 코드를 보내면
			if(resCode == 200) {
				// 데이터를 받아올 통로를 연결하기
				is = new InputStreamReader(httpCon.getInputStream());
			} else {
				// 만약 200 코드가 아니면
				// 오류 메세지를 받을 통로를 연결
				is = new InputStreamReader(httpCon.getErrorStream());
				
			}
			buffer = new BufferedReader(is);
			
			String retString = "";
			while(true) {
				String line =  buffer.readLine();
				if(line == null) break;
				retString += line;
			}
			return retString;
			
		} catch (MalformedURLException e) {
			log.debug("Query String 문자열 오류");
			return null;
		} catch (IOException e) {
			log.debug("네트워크 연결을 할 수 없음");
			return null;
		}
		
	}
	

	@Override
	public InfoVO getInfoList(String queryString) {
		

	}
}
