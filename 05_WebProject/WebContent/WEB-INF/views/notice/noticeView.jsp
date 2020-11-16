<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Notice n = (Notice)request.getAttribute("n");
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
					<th colspan="2"><%=n.getNoticeTitle() %></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(n.getFilename()!=null){ %>
						<img src="/img/file.png" width="16px">
						<a href="javascript:fileDownload('<%=n.getFilename()%>','<%=n.getFilepath()%>')"><%=n.getFilename() %></a>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=n.getNoticeContentBr() %></td>
				</tr>
				<tr style="text-align:center">
					<th colspan="2">
						<%if(m!=null && m.getMemId().equals(n.getNoticeWriter())) {%>
							<a href="/noticeUpdateForm?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-primary btn-sm">수정하기</a>
							<a href="/noticeDelete?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-primary btn-sm">삭제하기</a>
						<%} %>
						<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
					</th>					
				</tr>
			</table>
		</div>
	</section>
	<script type="text/javascript">
		function fileDownload(filename,filepath){
			var url = "/noticeFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			location.href=url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
	</script>
</body>
</html>