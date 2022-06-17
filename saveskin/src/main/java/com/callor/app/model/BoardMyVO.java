package com.callor.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardMyVO {

	public int b_num;			// 게시글 번호
	public String b_title;		// 제목
	public String username;		// 작성자
	public String w_date;		// 글 작성일
	public String w_time;		// 글 작성시간
	public int b_hit;			// 조회수
	
}
