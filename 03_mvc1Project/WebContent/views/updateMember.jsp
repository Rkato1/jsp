<%@page import="model.dao.MemberDao"%>
<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
	String pw = request.getParameter("memPw");
	String ph = request.getParameter("phone");
	String email = request.getParameter("email");
	int no = Integer.parseInt(request.getParameter("memNo"));
	String id = request.getParameter("memId");
	Member m = new Member();
	m.setMemNo(no);
	m.setMemId(id);
	m.setMemPw(pw);
	m.setEmail(email);
	m.setPhone(ph);
	int result = new MemberDao().updateMember(m);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(result>0){%>
		<script>
		alert("수정완료");
		location.href='/';		
		</script>
		<%
		session = request.getSession(false);
		Member loginMember = new MemberDao().selectOneMember(m);
		session.setAttribute("loginMember", loginMember);
  		%>
	<% }else{
	%>
		<script>
		alert("수정실패");
		location.href='/views/mypage.jsp';
		</script>
	<%} %>
</body>
</html>