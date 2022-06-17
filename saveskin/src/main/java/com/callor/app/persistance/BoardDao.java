package com.callor.app.persistance;

import java.util.List;

import com.callor.app.model.BoardMyVO;
import com.callor.app.model.BoardVO;

public interface BoardDao extends GenericDao<BoardVO, String> {

	public BoardVO findByNumber(int number);
	public List<BoardVO> findByTitle(String title);
	public List<BoardVO> findByContent(String content);
	
	public int deleteByNum(String id);
	
	
}
