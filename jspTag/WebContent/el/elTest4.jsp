<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연산자</h1>
	<hr>
	<table border=1>
		<tr>
			<th>표현식</th><th>값</th>
		</tr>
		<tr>
			<!-- \로 이스케이프 문자 활성화 -->
			<td>\${2+5 }</td><td>${2+5 }</td>
		</tr>
		<tr>
			<td>\${4/5 }</td><td>${4/5 }</td>
		</tr>
		<tr>
			<td>\${4 div 5 }</td><td>${4 div 5 }</td>
		</tr>
		<tr>
			<td>\${4 < 5 }</td><td>${4 < 5 }</td>
		</tr>
		<tr>
			<td>\${4 gt 5 }</td><td>${4 gt 5 }</td>
		</tr>
		<tr>
			<td>\${4 lt 5 }</td><td>${4 lt 5 }</td>
			<!-- < : lt,> : gt,<= : le,>= : ge -->
		</tr>
		<tr>
			<td>\${3 eq 3}</td><td>${3 eq 3 }</td>
		</tr>
		<tr>			
			<td>\${(4>3)?4:3 }</td><td>${(4>3)?4:3 }</td>
			<!-- 3항연산자 -->
		</tr>
		<tr>
			<td></td><td></td>
		</tr>
	</table>
	
</body>
</html>