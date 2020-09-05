<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	//1. 사용자 입력 정보 추출(검색 기능은 나중에)
	//2. DB 연동 처리
	BoardDTO vo = new BoardDTO();
	BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> boardList = boardDAO.getBoardList(vo);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...<a href="logout_proc.jsp">Log-out</a></h3>

<!-- 검색시작 -->
<form action="getBoardList.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<td align="right">
				<select name="searchCondition">
				<option value="TITLE">제목
				<option value="CONTENT">내용
				</select>
				<input name="searchKeyword" type="text"/>
				<input name="submit" value="검색"/>
			</td>
		</tr>
	</table>
</form>

<!-- 검색 목록 -->
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">번호</th>
			<th bgcolor="orange" width="200">제목</th>
			<th bgcolor="orange" width="150">작성자</th>
			<th bgcolor="orange" width="150">등록일</th>
			<th bgcolor="orange" width="100">조회수</th>
		</tr>
		
		<%for(BoardDTO board : boardList) {%>
		<tr>
			<td><%= board.getSeq() %></td>
			<td align="left"><a href="getBoard.jsp?seq=<%=board.getSeq() %>">
														<%=board.getTitle() %></a></td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getRegDate() %></td>
			<td><%= board.getCnt() %></td>
		</tr>		
		<%} %>
		
	</table>
<br>
<a href="insertBoard.jsp">새글 등록</a>
</center>
</body>
</html>