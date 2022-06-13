package com.callor.app.model;

public class CommentVO {

	public int c_num;				// 댓글 번호
	public String c_date;			// 작성 일시
	public String c_content;		// 댓글 내용
	public int b_num;				// 게시글 번호	fk
	public String userid;			// 작성자	fk	
}
