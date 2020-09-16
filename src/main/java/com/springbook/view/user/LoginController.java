package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserDTO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserDTO vo, UserDAO userDAO) {		
		if(userDAO.getUser(vo) != null)
			return "getBoardList.do";
		else {
			return "login.jsp";
		}
	}
	
}

