package com.springbook.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {
	@RequestMapping("/login.do")
	public String login(UserDTO vo, UserDAO userDAO) {		
		if(userDAO.getUser(vo) != null)
			return "getBoardList.do";
		else {
			return "login.jsp";
		}
	}
	
}

