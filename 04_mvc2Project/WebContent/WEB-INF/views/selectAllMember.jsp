<%@page import="model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전체회원조회</h1><hr>
<%
	if(list.size()==0) {
%>
	<h3>회원이 존재하지 않습니다.</h3>
	<%
	}else {
	%>
	<table border='1'>
		<tr>
			<th>회원번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>성별</th><th>가입일</th>
		</tr>
		<%
		for(int i=0; i<list.size(); i++) {%>
			<tr>
				<td><%=list.get(i).getMemNo()%></td>
				<td><%=list.get(i).getMemId()%></td>
				<td><%=list.get(i).getMemName()%></td>
				<td><%=list.get(i).getPhone()%></td>
				<td><%= list.get(i).getEmail()%></td>
				<td><%= list.get(i).getGender()%></td>
				<td><%=list.get(i).getEnrollDate()%></td>
			</tr>
		<%} %>
		</table>
	<%} %>
	<a href='/'>메인페이지로 이동</a>
</body>
</html>