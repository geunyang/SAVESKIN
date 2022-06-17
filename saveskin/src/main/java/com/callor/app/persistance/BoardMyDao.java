package com.callor.app.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.app.model.BoardMyVO;
import com.callor.app.model.BoardVO;
import com.callor.app.model.UserVO;

public interface BoardMyDao {

	/*
	 * mapper 와 연동할 때 mapper 에게 전달하는 변수가 2개 이상일 때는
	 * 각각의 변수에 @Param 속성을 지정해 주어야한다
	 * 그렇지 않으면 mapper 가 어떤 변수에 데이터가 담겨있는지 혼동하게 된다.
	 */
	public BoardMyVO findByNumAndUserName(
			@Param("b_num") int b_num,
			@Param("username") String username) ;

	public List<BoardVO> findByNumber(int b_num);
	public List<UserVO> findByUserName(String username);
	
	
	
	
	
}
