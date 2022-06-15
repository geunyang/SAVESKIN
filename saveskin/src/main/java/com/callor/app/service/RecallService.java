package com.callor.app.service;

import com.callor.app.model.RecallReturn;

public interface RecallService {
	public String queryString(int num);
	public RecallReturn getRecallList(String queryString);
}