<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 학생 정보</h1>
	<hr>
	<table border=1>
		<tr>
			<th>번호</th><th>이름</th><th>전화번호</th><th>Email</th><th>주소</th>
		</tr>
		<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.stuNo }</td>
				<td>${s.stuName }</td>
				<td>${s.stuPhone }</td>
				<td>${s.email }</td>
				<td>${s.addr }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>