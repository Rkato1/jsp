<%@page import="model.dao.MemberDao"%>
<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Member m = (Member) session.getAttribute("loginMember");
	int result = new MemberDao().deleteMember(m);
	
	//세션파기코드
	session.invalidate();	
	
	%>
	<script>
	alert('탈퇴되었습니다.');
	location.href='/';
	</script>
</body>
</html>