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
	<table border=1>
		<tr>
			<th>번호</th><th>이름</th><th>나이</th><th>주소</th>
		</tr>
		<!-- for(Member m : list) -->
		<c:forEach items="${list }" var="m" varStatus="i">
			<tr>
			<!-- index는 0부터 count는 1부터 시작 -->
				<td><c:out value="${i.count }"/></td>
				<td>${m.name }</td>
				<td>${m.age }</td>
				<td>${m.addr }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
