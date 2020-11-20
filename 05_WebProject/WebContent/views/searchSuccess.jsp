<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	User u = (User)request.getAttribute("u");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보</h1>
<table border="1px solid black">
	<tr>
		<th>회원번호</th>
		<th>회원아이디</th>
		<th>회원이름</th>
		<th>회원나이</th>
	</tr>
	<tr>
		<th><%=u.getUserNo() %></th>
		<th><%=u.getUserId() %></th>
		<th><%=u.getUserName() %></th>
		<th><%=u.getUserAge() %></th>
	</tr>
</table>
</body>
</html>