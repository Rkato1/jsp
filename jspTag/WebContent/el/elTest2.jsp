<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>첫번째</h2>
	이름 : ${list[0].name}<br>
	나이 : ${list[0].age}<br>
	주소 : ${list[0].addr}<br>
	<hr>
	<h2>두번째</h2>
	이름 : ${list[1].name}<br>
	나이 : ${list[1].age}<br>
	주소 : ${list[1].addr}
</body>
</html>