package com.callor.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * recall 리스트, 상세리스트 담을 VO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName="content")
public class RecallVO {
	private String recallSn; //리콜번호(PK)
	private String productNm; //제품명
	private String makr; //제조사
	private String mnfcturPd; //제조기간
	private String mnfcturNoInfo; //제조번호 정보
	private String recallSe; //리콜 구분
	private String recallPublictBgnde; //리콜 공표시작일
	private String recallPublictEndde; //리콜 공표만료일
	private String infoOriginInstt; //정보 출처 기관
	private String shrtcomCn; //결함 내용
	private String recallEntrpsInfo; //문의처,사업자 주소
}
