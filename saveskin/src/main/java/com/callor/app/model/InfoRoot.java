package com.callor.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class InfoRoot {

	@JsonProperty("body")
	public InfoParent infoParent;
	
}
