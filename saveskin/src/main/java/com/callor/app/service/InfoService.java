package com.callor.app.service;

import com.callor.app.model.InfoParent;

public interface InfoService {
	public String queryString();
	public InfoParent getInfoList(String queryString);

}
