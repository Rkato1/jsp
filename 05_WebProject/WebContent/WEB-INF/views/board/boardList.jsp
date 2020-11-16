<%@page import="board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	#pageNavi>*{
		margin:10px;
	}
	.selectPage{
		font-size: 18px;
		color:blue;
	}
</style>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="text-align:center;width:80%;margin:0 auto;">
			<%if(m!=null){ %>
			<div style="text-align:right;">
				<a href="/boardWriteForm" class="btn btn-primary btn-sm">글쓰기</a>
			</div>
			<%} %>
			<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight: bold">
						게시판</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<%for(Board b : list){ %>
					<tr>
						<th><%=b.getrNum() %></th>
						<th><a href="/boardView?boardNo=<%=b.getBoardNo() %>"><%=b.getBoardTitle() %></a></th>
						<th><%=b.getBoardWriter() %></th>
						<th><%=b.getBoardDate() %></th>
					</tr>
				<%} %>
			</table>
			<div id="pageNavi"><%=pageNavi %></div>
		</div>
	</section>
</body>
</html>