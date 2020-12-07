<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp:forward tag</h1>
	<hr>
	<h2>forward가 동작한다면 지금 이 글은 보이지 않습니다!!!!!!!!!!</h2>
	<%if(false) {%>
	<jsp:forward page="/actionTag/forward.jsp"/>
	<%}else{ %>
	<jsp:forward page="/actionTag/forward2.jsp"/>
	<%} %>
</body>
</html>