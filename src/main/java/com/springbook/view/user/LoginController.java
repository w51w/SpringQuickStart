package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserDTO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserDTO vo, UserDAO userDAO, HttpSession session) {	
		UserDTO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName()); //세션에 저장된 사용자를 
			return "getBoardList.do";	//getBoardist.jsp에 출력할 수 있게 한다.
		}
		else return "login.jsp";
		
	}
	
}

