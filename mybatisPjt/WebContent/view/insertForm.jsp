<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 등록 페이지</h1>
	<hr>
	<form action="/insert" method="post">
		<fieldset>
			이름 : <input type="text" name="stuName"><br>
			전화번호 : <input type="text" name="stuPhone"><br>
			이메일 : <input type="text" name="email"><br>
			주소 : <input type="text" name="addr"><br>
			<input type="submit" value="등록하기">
		</fieldset>
	</form>
</body>
</html>