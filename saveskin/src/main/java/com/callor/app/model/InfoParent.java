package com.callor.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.ToString;

@ToString
public class InfoParent {
	
	@JsonProperty("pageNo")
	public String pageNo;
	
	@JsonProperty("totalCount")
	public String totalCount;
	
	@JsonProperty("items")
	public List<InfoVO> items;

}
