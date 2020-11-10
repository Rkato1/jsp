<%@ page import="model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    Member loginMember = (Member)session.getAttribute("loginMember");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<fieldset>
	<legend>내정보</legend>
	<form action="/views/updateMember.jsp" method="post">
		번호:<input type="text" name="memNo" value="<%=loginMember.getMemNo() %>" readonly><br>
		아이디:<input type="text" name="memId" value="<%=loginMember.getMemId() %>" readonly><br>
		비밀번호:<input type="password" name="memPw" value="<%=loginMember.getMemPw() %>"><br>
		이름:<input type="text" name="memName" value="<%=loginMember.getMemName() %>" readonly><br>
		전화번호:<input type="text" name="phone" value="<%=loginMember.getPhone() %>"><br>
		EMail:<input type="text" name="email" value="<%=loginMember.getEmail() %>"><br>
		성별:<input type="text" name="gender" value="<%=loginMember.getGender() %>" readonly><br>
		가입일:<input type="text" name="enrollDate" value="<%=loginMember.getEnrollDate() %>" readonly><br>
		<input type="submit" value="정보수정">
	</form>
	<a href="/">메인페이지로</a>
	</fieldset>
</body>
</html>