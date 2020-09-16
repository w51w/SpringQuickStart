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
		<a href="login.do">로그인(클라이언트가 URL을 직접 입력하거나 하이퍼링크를 클릭하여 요청하면 GET방식이다.
		그리고 UserDTO객체의 변수에 접근할 때 첫글자를 소문자로 변경한 이름이 자동 설정 된다.)</a><br><br><br>
		<a href="getBoardList.do">글 목록 바로가기</a>
	<hr>
</center>
</body>
</html>