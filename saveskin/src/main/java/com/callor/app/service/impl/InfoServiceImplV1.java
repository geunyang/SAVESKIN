package com.callor.app.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.app.config.InfoAPIConfig;
import com.callor.app.model.InfoRoot;
import com.callor.app.model.InfoVO;
import com.callor.app.service.InfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfoServiceImplV1 implements InfoService {

	@Override
	public String queryString() {

		StringBuilder urlBuilder = new StringBuilder(InfoAPIConfig.URL);
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "="+ InfoAPIConfig.SERVICE_KEY);
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); // 한페이지결과수
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); // 페이지번호
//			urlBuilder.append("&" + URLEncoder.encode("entp_name", "UTF-8") + "=" + URLEncoder.encode("태후", "UTF-8")); // 업체명
			urlBuilder.append("&type=json");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlBuilder.toString();
	}

	@Override
	public List<InfoVO> getInfoList(String queryString) {

		URI restURI = null;
		log.debug(queryString);
		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("URI 문법오류");
			return null;
		}

		/*
		 * NaverParent 는 List<VO> 타입의 items 변수를 갖는데 여기에서 VO type 을 BookVO 로 확정지어준다
		 */
		// 받기
		RestTemplate restTemp = new RestTemplate();

		ResponseEntity<InfoRoot> resData = null;
		resData = restTemp.exchange(restURI, HttpMethod.GET, null, InfoRoot.class);
		log.debug(resData.getBody().toString());
		return resData.getBody().infoParent.items;
//		return null;

		// naver 에서 받은 데이터는 resData 의 body 에 담겨있다
		// body 데이터를 get 하여 그 데이터 중에서 items 만 추출하여
		// Controller 로 return

	}

}
