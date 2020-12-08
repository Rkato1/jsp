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
	<h2>c:set</h2>
	<c:set var="num1" value="10"/>
	<c:set var="num2" value="20"/>
	<p>결과 : ${num1 }+ ${num2 } = ${num1+num2 }
	<hr>
	<h2>c:set scope</h2>
	<c:set var="num3" value="100" scope="request"/>
	<c:set var="num4" value="200" scope="session"/>
	<p>결과 : ${requestScope.num3 } / ${sessionScope.num4 }</p>
	<hr>
	<h2>c:remove</h2>
	<c:remove var="num3" scope="request"/>
	<p>결과 : ${requestScope.num3 } / ${sessionScope.num4 }</p>
	<hr>
	<h2>c:out</h2>
	출력 : 10<br>
	출력 : ${num1 }<br>
	출력 : <c:out value="${num1 }"/><br>
	출력 : <c:out value="10"/><br>
	<br>
	기본 출력 : 글씨를 진하게 하려면 Bold태그인  <b></b>를 쓰면 되죠!<br>
	기본 출력(escape옵션) : <c:out value="글씨를 진하게 하려면 Bold태그인  <b></b>를 쓰면 되죠!" escapeXml="false"/><br>
	기본 출력(escape옵션) : <c:out value="글씨를 진하게 하려면 Bold태그인  <b></b>를 쓰면 되죠!" escapeXml="true"/><br>
</body>
</html>