<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="width:80%;margin:0 auto;">
			<form action="/insertBoard" method="post" enctype="multipart/form-data">
				<table class="table table-bordered">
					<tr>
						<th colspan="2">공지사항 작성</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="boardTitle"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=m.getMemId() %>
							<input type="hidden" name="boardWriter" value="<%=m.getMemId() %>">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="boardContent" class="form-control" rows="3" cols="40"></textarea></td>
					</tr>
					<tr style="text-align: center;">
						<th colspan="2"><button type="submit" class="btn btn-primary">등록하기</button></th>
					</tr>
				</table>
			</form>
		</div>
	</section>
</body>
</html>