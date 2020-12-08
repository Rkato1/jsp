<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div class="table-wrapper" style="text-align:center;width:80%;margin:0 auto;">
			<c:if test=${sessionScope.m!=null && sessionScope.m.memLevel == 1 }>
			<div style="text-align:right;">
				<a href="/noticeWriteForm" class="btn btn-primary btn-sm">글쓰기</a>
			</div>
			</c:if>
			<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight: bold">
						공지사항</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<c:forEach items="${list }" var="n" varStatus="i">
					<tr>
						<th>${n.rNum }</th>
						<th><a href="/noticeView?noticeNo=${n.noticeNo } %>">n.noticeTitle</a></th>
						<th>${n.noticeWriter }</th>
						<th>${n.noticeDate }</th>
					</tr>
				</c:forEach>				
			</table>
			<div id="pageNavi">${pageNavi }</div>
		</div>
	</section>
</body>
</html>