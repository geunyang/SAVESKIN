package com.callor.app.service;

import com.callor.app.model.InfoVO;

public interface InfoService {
	public String queryString();
	public InfoVO getInfoList(String queryString);

}
