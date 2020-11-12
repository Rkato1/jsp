<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member member = (Member)request.getAttribute("memberMypage");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/updateMember" method="post" style="width:800px;margin:0 auto; color:black;">
			<h1>마이페이지</h1>
			<table class="table">
				<tr>
					<th>회원번호</th>
					<td>
						<input type="text" name="memNo" class="form-control" value="<%=member.getMemNo() %>" readonly>
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="memId" class="form-control" value="<%=member.getMemId() %>" readonly>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="memPw" class="form-control" value="<%=member.getMemPw() %>">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="memName" class="form-control" value="<%=member.getMemName() %>" readonly>
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="phone" class="form-control" value="<%=member.getPhone() %>">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="address" class="form-control" value="<%=member.getAddress() %>">
					</td>
				</tr>
				<tr>
					<th>회원등급</th>
					<td>
					<%if(member.getMemLevel()==1) {%>
						<span>관리자</span>
					<%}else if(member.getMemLevel()==2) { %>
						<span>정회원</span>
					<%} %>
						<input type="text" name="memLevel" class="form-control" value="<%=member.getMemLevel()%>" readonly>
					</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>
						<input type="text" name="enrollDate" class="form-control" value="<%=member.getEnrollDate() %>" readonly>
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align:center">
					<button class="btn btn-outline-danger btn-lg" type="submit">수정하기</button>
					<%if(member.getMemLevel()==1) {%>
						<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/adminPage'">회원관리</button>
					<%}else{ %>
						<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/deleteMember?memId=<%=member.getMemId()%>'">회원탈퇴</button>
					<%} %>
					</th>
				</tr>
				
			</table>
		</form>
	</section>
</body>
</html>