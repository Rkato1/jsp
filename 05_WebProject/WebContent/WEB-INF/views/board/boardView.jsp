<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board b = (Board)request.getAttribute("b");
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
		<div class="table-wrapper" style="width:80%;margin:0 auto;">
			<table class="table table-bordered">
				<tr>
					<th colspan="2"><%=b.getBoardTitle() %></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=b.getBoardWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(b.getFilename()!=null){ %>
						<img src="/img/file.png" width="16px">
						<a href="javascript:fileDownload('<%=b.getFilename()%>','<%=b.getFilepath()%>')"><%=b.getFilename() %></a>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=b.getBoardContentBr() %></td>
				</tr>
				<tr style="text-align:center">
					<th colspan="2">
						<%if(m!=null && m.getMemId().equals(b.getBoardWriter())) {%>
							<a href="/boardUpdateForm?boardNo=<%=b.getBoardNo() %>" class="btn btn-primary btn-sm">수정하기</a>
							<a href="/boardDelete?boardNo=<%=b.getBoardNo() %>" class="btn btn-primary btn-sm">삭제하기</a>
						<%} %>
						<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
					</th>					
				</tr>
			</table>
		</div>
	</section>
	<script type="text/javascript">
		function fileDownload(filename,filepath){
			var url = "/boardFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			location.href=url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
	</script>
</body>
</html>