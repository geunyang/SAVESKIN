package com.callor.app.persistance;

import java.util.List;

import com.callor.app.model.CommentVO;

public interface CommentDao extends GenericDao<CommentVO, String> {

	public List<CommentVO> findByDate(String date);

}
