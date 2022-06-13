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
public class BoardListVO {

	public int b_num;			// 게시글 번호
	public String b_title;		// 제목
	public String userid;		// 작성자
	public String w_date;		// 글 작성일
	public int b_hit;			// 조회수
	
}
