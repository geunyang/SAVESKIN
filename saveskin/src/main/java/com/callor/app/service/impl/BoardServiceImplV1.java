package com.callor.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.app.model.BoardListVO;
import com.callor.app.model.BoardVO;
import com.callor.app.persistance.BoardDao;
import com.callor.app.service.BoardService;

@Service("boardServiceV1")
public class BoardServiceImplV1 implements BoardService {
	
	private final BoardDao boardDao;
	
	public BoardServiceImplV1(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardList = boardDao.selectAll();
		return boardList;
	}

	@Override
	public BoardVO findByNumber(String b_num) {
		
		return boardDao.findByNumber(b_num);
	}

	@Override
	public List<BoardVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> findByContent(String content) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BoardVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardVO vo) {
		boardDao.insert(vo);
		return 0;
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
