package com.callor.app.persistance;

import java.util.List;

import com.callor.app.model.BoardListVO;
import com.callor.app.model.BoardVO;

public interface BoardDao extends GenericDao<BoardVO, String> {

	public BoardVO findByNumber(String number);
	public List<BoardVO> findByTitle(String title);
	public List<BoardVO> findByContent(String content);
	
	
	
}
