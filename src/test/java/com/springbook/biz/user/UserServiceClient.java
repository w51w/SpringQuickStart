package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. Spring �����̳� ����
				AbstractApplicationContext container = 
						new GenericXmlApplicationContext("applicationContext.xml");
				
				//2. Spring �����̳ʷκ��� BoardServiceImpl ��ü�� Lookup�Ѵ�.
				UserService userService = (UserService) container.getBean("userService");
				
				UserDTO vo = new UserDTO();
				vo.setId("test");
				vo.setPassword("test123");
				
				UserDTO user = userService.getUser(vo);
				if(user != null) {
					System.out.println(user.getName() + "�� ȯ���մϴ�.");
				}
				else {
					System.out.println("�α��� ����");
				}
				
				container.close();
			}
}
