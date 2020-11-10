<%@ page import="model.vo.Member" %>
<%@ page import="model.dao.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1.인코딩
    	request.setCharacterEncoding("utf-8");
    	//2.view에서 보낸 데이터 저장
    	String memId = request.getParameter("memId");
    	String memPw = request.getParameter("memPw");
    	Member m = new Member();
    	m.setMemId(memId);
    	m.setMemPw(memPw);
    	//3.비지니스 로직
    	Member loginMember = new MemberDao().selectOneMember(m);
    	//4.결과처리
    	if(loginMember!=null){
    		session.setAttribute("loginMember", loginMember);
    	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		<%
		if(loginMember!=null){
			%>
			alert("로그인 성공");
			location.href="/";
			<%
		}else{%>
			alert("아이디 또는 비밀번호를 확인해주세요");
			location.href="/views/loginForm.html";
		<%
		}
		%>
	</script>
</body>
</html>