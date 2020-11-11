<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Member member = (Member)request.getAttribute("member");
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
	<form action="updateMember" method="post">
		번호:<input type="text" name="memNo" value="<%=member.getMemNo() %>" readonly><br>
		아이디:<input type="text" name="memId" value="<%=member.getMemId() %>" readonly><br>
		비밀번호:<input type="password" name="memPw" value="<%=member.getMemPw() %>"><br>
		이름:<input type="text" name="memName" value="<%=member.getMemName() %>" readonly><br>
		전화번호:<input type="text" name="phone" value="<%=member.getPhone() %>"><br>
		EMail:<input type="text" name="email" value="<%=member.getEmail() %>"><br>
		성별:<input type="text" name="gender" value="<%=member.getGender() %>" readonly><br>
		가입일:<input type="text" name="enrollDate" value="<%=member.getEnrollDate() %>" readonly><br>
		<input type="submit" value="정보수정">
	</form>
</body>
</html>