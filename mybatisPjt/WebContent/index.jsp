<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	<h1>학생관리 프로그램</h1>
	<hr>
	<h1><a href="/view/insertForm.jsp">1. 학생 등록</a></h1>
	<hr>
	<h2>2. 학생 조회</h2>
	<form action="/searchStudent">
		<input type="text" name="stuNo" placeholder="학생번호입력">
		<input type="submit" value="조회">
	</form>
	<hr>
	<h2><a href="/searchAllStudent">3. 학생 전체 조회</a></h2>
	<hr>
	<h2>4. 학생 삭제</h2>
	<form action="/deleteStudent">
		<input type="text" name="stuNo" placeholder="학생번호입력">
		<input type="submit" value="삭제">
	</form>
	<hr>
	<h2>5. 학생 수정</h2>
	<form action="/updateStudentForm">
		<input type="text" name="stuNo" placeholder="수정할학생번호입력">
		<input type="submit" value="수정페이지로이동">
	</form>
	-->
	<!-- 로그인안했을떄 -->
	<!-- 
	<h1><a href="/login">1. 로그인</a></h1>
	<h1><a href="/insertMember">2. 회원가입</a></h1>
	 -->
	 <!-- 로그인했을떄 -->
	<h1><a href="/login">1. 전체회원 조회</a></h1>
	<h1><a href="/insertMember">2. 마이페이지</a></h1>
	<h1><a href="/insertMember">3. 회원탈퇴</a></h1>
	<h1><a href="/insertMember">4. 로그아웃</a></h1>
</body>
</html>
