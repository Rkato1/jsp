<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생관리 프로그램</h1>
	<hr>
	<h1><a href="/view/insertForm.jsp">1. 학생 등록</a></h1>
	<hr>
	<form action="/searchStudent">
		<input type="text" name="stuNo" placeholder="학생번호입력">
		<input type="submit" value="조회">
	</form>
</body>
</html>