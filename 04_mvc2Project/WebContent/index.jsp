<%@page import="model.vo.Member"%>
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
	<a href="/WEB-INF/views/joinForm.html">회원가입페이지</a><br>
	<a href="/WEB-INF/views/selectAllMember.jsp">전체회원조회</a>
<%if(loginMember==null){ %>
	<fieldset>
	<legend>로그인</legend>
	<form action="/login" method="post">
		아이디:<input type="text" name="memId"><br>
		비밀번호:<input type="password" name="memPw"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="초기화">
		<br>
		<a href="/views/joinForm.html">회원가입</a>
	</form>
	</fieldset>
	<%}else{ %>
	<h1>[<%=loginMember.getMemName() %>]</h1>
	<h3><a href="/mypage">마이페이지</a></h3>
	<h3><a href="/selectAllMember">전체회원조회</a></h3>
	<%} %>
</body>
</html>