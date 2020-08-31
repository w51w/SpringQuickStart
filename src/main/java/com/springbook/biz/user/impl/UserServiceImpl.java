package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.UserService;

//<bean>으로 객체 생성 예정
public class UserServiceImpl implements UserService{
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public UserDTO getUser(UserDTO vo) {
		return userDAO.getUser(vo);
	}
	

}
