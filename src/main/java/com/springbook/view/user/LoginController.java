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
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method = RequestMethod.POST)
	public String login(UserDTO vo, UserDAO userDAO, HttpSession session) {	
		UserDTO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName()); //���ǿ� ����� ����ڸ� 
			return "getBoardList.do";	//getBoardist.jsp�� ����� �� �ְ� �Ѵ�.
		}
		else return "login.jsp";
		
	}
	
}

