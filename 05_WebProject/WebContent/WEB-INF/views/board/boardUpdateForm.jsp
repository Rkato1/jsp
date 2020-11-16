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
			<form action="/boardUpdate" method="post" enctype="multipart/form-data">
			<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>"> 
			<table class="table table-bordered">
				<tr>
					<th colspan="2"><input type="text" name="boardTitle" class="form-control" value="<%=b.getBoardTitle() %>"></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=b.getBoardWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="hidden" id="status" name="status" value="stay">
						<%if(b.getFilename() !=null) {%>
							<img src="/img/file.png" width="16px" class="delFile">
							<input type="file" name="filename" id="file" style="display:none;">
							<span class="delFile"><%=b.getFilename() %></span>
							<button type="button" id="fileDelBtn" class="btn btn-primary btn-sm delFile">삭제</button>
							<input type="hidden" name="oldFilename" value="<%=b.getFilename() %>">
							<input type="hidden" name="oldFilepath" value="<%=b.getFilepath() %>">
						<%} else { %>
							<input type="file" name="filename">
						<%}%>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="boardContent" class="form-control" rows="3" cols="40"><%=b.getBoardContent() %></textarea></td>
				</tr>
				<tr style="text-align:center">
					<th colspan="2">
						<button type="submit" class="btn btn-primary">수정완료</button>
						<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
					</th>				
				</tr>
			</table>
			</form>
		</div>
	</section>
	<script type="text/javascript">
		$('#fileDelBtn').click(function(){
			if(confirm('첨부파일을 삭제하시겠습니까?'));
			$(".delFile").hide();
			$("#file").show();
			$("#status").val("delete");
		});
	</script>
</body>
</html>