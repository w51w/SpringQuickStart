package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserDTO;

//<bean>등록으로 객체를 생성할 예정
public class UserDAO  {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String USER_GET = "select * from users where id=? and password=?";
	
	public UserDTO getUser(UserDTO vo){
		UserDTO user = null;
		
		try {
			System.out.println("====> JDBC로 getUser() 기능 처리");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserDTO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
}
