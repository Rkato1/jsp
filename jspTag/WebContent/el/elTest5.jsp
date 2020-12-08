<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내장객체사용</h1>
	<hr>
	<h3>첫번째 회원 정보</h3>
	이름 : ${requestScope.m.name }<br>
	나이 : ${requestScope.m.age }<br>
	주소 : ${requestScope.m.addr }<br>
	<h3>두번째 회원 정보</h3>
	이름 : ${requestScope.m2.name }<br>
	나이 : ${requestScope.m2.age }<br>
	주소 : ${requestScope.m2.addr }<br>
	<h3>세번째 회원 정보</h3>
	이름 : ${sessionScope.m3.name }<br>
	나이 : ${sessionScope.m3.age }<br>
	주소 : ${sessionScope.m3.addr }<br>
	<h3>네번째 회원 정보</h3>
	<!-- sessionScope를 붙이지 않으면 구분하지 않고 먼저 찾는 값 반환 -->
	이름 : ${sessionScope.m.name }<br>
	나이 : ${sessionScope.m.age }<br>
	주소 : ${sessionScope.m.addr }<br>
</body>
</html>