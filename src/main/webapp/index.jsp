<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<center>
	<h1>게시판 프로그램</h1>
	<hr>
		<a href="login.do">로그인</a><br><br><br>
		클라이언트가 URL을 직접 입력하거나 하이퍼링크를 클릭하여 요청하면 GET방식이다.<br>
		그리고 UserDTO객체의 변수에 접근할 때 첫글자를 소문자로 변경한 이름이 자동 설정 된다.<br>
		login.jsp/ 에서 value="%{userDTO.멤버변수}"로 접근 가능<br>
		전제<br>
		1-컨트롤러에서 loginView(UserDTO vo) 메소드에서 id 와 password가 set되어 있는 상태<br>
		2-컨트롤러에서 ModelAndView 객체의 addObject(key, value) 에서 value를 DTO객체로 설정했을 때<br>
		(boardController/getBoard getBoardList)<br>
		<a href="getBoardList.do">글 목록 바로가기</a><br>
		<a href="dataTransfrom.do">글 목록 변환 처리</a><br>
	<hr>
</center>
</body>
</html>