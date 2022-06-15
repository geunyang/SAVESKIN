package com.callor.app.service;

import com.callor.app.model.InfoParent;

public interface InfoService {
	public String queryString(String num);
	public InfoParent getInfoList(String queryString);

}
