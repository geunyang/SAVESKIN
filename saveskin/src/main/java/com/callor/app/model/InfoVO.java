package com.callor.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class InfoVO {
	
	@JsonProperty("INDUTY")
	private String INDUTY; // 업종
	
	@JsonProperty("ENTP_SEQ")
	private String ENTP_SEQ; // 업체번호
	
	@JsonProperty("ENTP_NAME")
	private String ENTP_NAME; // 업체명
	
	@JsonProperty("BOSS_NAME")
	private String BOSS_NAME; // 대표자명
	
	@JsonProperty("ENTP_PERMIT_DATE")
	private String ENTP_PERMIT_DATE; // 허가일자
	
	@JsonProperty("FACTORY_ADDR")
	private String FACTORY_ADDR; // 본사주소
	
}
