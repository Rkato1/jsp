<%@ page import="model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Member loginMember = (Member)session.getAttribute("loginMember");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원관리 mvc1</h1>
	<hr>
	
	<%if(loginMember==null){ %>
	<h3><a href="/views/loginForm.html">1. 로그인</a></h3>	
	<h3><a href="/views/joinForm.html">2. 회원가입</a></h3>
	<%}else{ %>
	<h3>[<%=loginMember.getMemName() %>]</h3>
	<h3><a href="/views/mypage.jsp">1. 마이페이지</a></h3>
	<h3><a href="/views/logout.jsp">2. 로그아웃</a></h3>
	<h3><a href="/views/exitMember.jsp">3. 회원탈퇴</a></h3>
	<%} %>
</body>
</html>