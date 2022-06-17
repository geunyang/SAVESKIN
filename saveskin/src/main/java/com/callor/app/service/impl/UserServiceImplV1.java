package com.callor.app.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.app.model.UserVO;
import com.callor.app.persistance.UserDao;
import com.callor.app.service.UserService;

@Service
public class UserServiceImplV1 implements UserService{
	
	protected final PasswordEncoder pass;
	
	private final UserDao userDao;
	
	public UserServiceImplV1(UserDao userDao, PasswordEncoder pass) {
		this.pass = pass;
		this.userDao = userDao;
	}

	@Override
	public List<UserVO> selectAll() {
		List<UserVO> userList = userDao.selectAll();
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public UserVO findById(String userid) {
		// TODO Auto-generated method stub
		return userDao.findById(userid);
	}
	@Override
	public UserVO findByName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByName(username);
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		
		return userDao.update(vo);
	}

	@Override
	public int delete(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// TODO 유저 로그인 처리
	@Override
	public UserVO login(UserVO userVO) {
		//Controller에서 전달받은 로그인 정보에서
				//username과 password 추출
				String userid = userVO.getUserid();
				String password = userVO.getPassword();
				
				//username으로 회원 DB에서 데이터 Select
				UserVO joinUserVO = userDao.findById(userid);
				
				//Select한 데이터가 null 이면 username은 없다
				//잘못 입력했거나 아직 회원가입 하지 않은 상태
				//Select한 데이터가 null이 아니면 username이 있다.
				if(joinUserVO != null) {
					//username으로 조회한 데이터가 있으면
					//DB에 저장된 password와 입력한 password 비교
					boolean bYes = pass.matches(password, joinUserVO.getPassword());
					
					//비밀번호가 일치하지 않으면
					//hull을 retrun하고 종료하기
					//if(!bYes)
					if(bYes == false) {
						return null;
					}
				}
				//정상 로그인이 되면 joinUSerVO에는 사용자 정보 데이터가 담기고
				//그렇지 않으면 null 값이 담겨있다.
				return joinUserVO;
	}

	// TODO 회원가입 처리
	@Override
	public UserVO join(UserVO userVO) {
		List<UserVO> userList = userDao.selectAll();
		
		if(userList == null || userList.size() <1) {
			userVO.setRole("ADMIN");
		}else {
			userVO.setRole("USER");
		}
		userDao.insert(userVO);
		return null;
	}

	
}
