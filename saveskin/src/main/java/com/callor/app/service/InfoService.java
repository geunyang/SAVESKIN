package com.callor.app.service;

import java.util.List;

import com.callor.app.model.InfoVO;

public interface InfoService {
	public String queryString(String search);
	public List<InfoVO> getInfoList(String queryString);

}
