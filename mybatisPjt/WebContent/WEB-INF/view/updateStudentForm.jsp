<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- if test="조건식 1 and/or 조건식2" -->
<!-- <trim prefix="where" prefixOverrids="and|or">
조건 여러개일떄 사용
	<if test="">
	</if>
	<if test="">
	</if>
</trim> -->
	<h1>학생 정보 수정</h1>
	<hr>
	<form action="/updateStudent" method="post">
		<fieldset>
			번호 : <input type="text" name="stuNo" value="${s.stuNo }" readonly><br>
			이름 : <input type="text" name="stuName" value="${s.stuName }" readonly><br>
			전화번호 : <input type="text" name="stuPhone" value="${s.stuPhone }"><br>
			email : <input type="text" name="email" value="${s.email }"><br>
			주소 : <input type="text" name="addr" value="${s.addr }"><br>
			<input type="submit" value="수정하기">
		</fieldset>
	</form>
</body>
</html>