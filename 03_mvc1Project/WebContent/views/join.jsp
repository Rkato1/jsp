<%@ page import="model.vo.Member" %>
<%@ page import="model.dao.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	Member m = new Member();
    	m.setMemId(request.getParameter("memId"));
    	m.setMemPw(request.getParameter("memPw"));
    	m.setMemName(request.getParameter("memName"));
    	m.setGender(request.getParameter("gender"));
    	m.setEmail(request.getParameter("email"));
    	m.setPhone(request.getParameter("phone"));
    	int result = new MemberDao().insertMember(m);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 결과</h1>
	<hr>
	<%if(result>0){ %>
	<h3>[<%=m.getMemName() %>]님 환영합니다.</h3>
	<a href="/views/loginForm.html">로그인하기</a><br>
	<a href="/">메인페이지로 가기</a>
	<%} else { %>
	<h3>회원가입에 실패했습니다. 관리자에게 문의하세요.</h3>
	<a href="/">메인페이지로 가기</a>
	<%} %>
</body>
</html>