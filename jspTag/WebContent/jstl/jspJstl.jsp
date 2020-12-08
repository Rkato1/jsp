<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 사용</h1>
	<hr>
	<h3><a href="/jstl/jstlBasic.jsp">1. JSTL기초</a></h3>
	<form action="/jstlIf">
		<input type="text" name="num">
		<input type="submit" value="전송">
	</form>
	<hr>
	<form action="/jstlChoose">
		<input type="text" name="num" placeholder="1~3의 숫자 중 1개 입력">
		<input type="submit" value="전송">
	</form>	
	<hr>
	<h3><a href="/jstlForEach">4. forEach</a></h3>
	<hr>
	<form action="/jstlForTokens">
		<input type="text" name="hobby" placeholder="취미를 입력하세요. 여러개인 경우 ','로 구분">
		<input type="submit" value="전송">
	</form>
</body>
</html>