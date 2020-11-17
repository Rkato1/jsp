<%@page import="notice.model.vo.NoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Notice n = (Notice)request.getAttribute("n");
    	ArrayList<NoticeComment> list = (ArrayList<NoticeComment>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/comment.css">
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
			<%if(m!=null){ %>
				<div class="inputComment">
					<form action="/insertNoticeComment" method="post">
						<ul>
							<li>
								<input type="hidden" name="noticeCommentLevel" value="1">
								<input type="hidden" name="noticeCommentWriter" value="<%=m.getMemId() %>">
								<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
								<input type="hidden" name="noticeCommentRef" value="0">
								<textarea class="form-control" name="noticeCommentContent"></textarea>
							</li>
							<li>
								<button type="submit" class="btn btn-secondary btn-lg btn-block">등록</button>
							</li>
						</ul>
					</form>
				</div>
			<%} %>
			<div class="commentList">
				<%for(NoticeComment nc : list) {%>
					<%if(nc.getNoticeCommentLevel() == 1) {%>
						<ul>
							<li>
								<p><%=nc.getNoticeCommentWriter() %></p>
								<p><%=nc.getNoticeCommentDate() %></p>
							</li>
							<li>
								<p><%=nc.getNoticeCommentContentBr() %></p>
								<textarea name="noticeCommentContent" class="form-control changeComment" style="display:none;"><%=nc.getNoticeCommentContent() %></textarea>
								<%if(m!=null){ %>
								<p class="linkBox">
									<%if(m.getMemId().equals(nc.getNoticeCommentWriter())) {%>
									<a href="javascript:void(0)" onclick="modifyComment(this,'<%=nc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">수정</a>
									<a href="javascript:void(0)" onclick="deleteComment(this,'<%=nc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">삭제</a>
									<%} %>
									<a href="javascript:void(0)" class="recShow">답글달기</a>
								</p>
								<div class="inputComment re">
									<form action="/insertNoticeComment" method="post">
										<ul>
											<li>
												<input type="hidden" name="noticeCommentLevel" value="2">
												<input type="hidden" name="noticeCommentWriter" value="<%=m.getMemId() %>">
												<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
												<input type="hidden" name="noticeCommentRef" value="<%=nc.getNoticeCommentNo()%>">
												<textarea class="form-control" name="noticeCommentContent"></textarea>
											</li>
											<li>
												<button type="submit" class="btn btn-secondary btn-lg btn-block">등록</button>
												<button type="button" class="btn btn-secondary btn-lg btn-block recCancel">취소</button>
											</li>
										</ul>
									</form>
								</div>
								<%} %>
							</li>							
						</ul>
						<%for(NoticeComment ncc : list){ //대댓글출력지점%>
							<%if(ncc.getNoticeCommentLevel()==2 && ncc.getNoticeCommentRef() == nc.getNoticeCommentNo()) {%>
								<ul class="rere">
									<li>┗</li>
									<li>
										<p><%=ncc.getNoticeCommentWriter() %></p>
										<p><%=ncc.getNoticeCommentDate() %></p>
									</li>
									<li>
										<p><%=ncc.getNoticeCommentContentBr() %></p>
										<textarea name="noticeCommentContent" class="form-control changeComment" style="display:none;"><%=ncc.getNoticeCommentContent() %></textarea>
										<%if(m!=null) {%>
										<p class="linkBox">
											<%if(m.getMemId().equals(ncc.getNoticeCommentWriter())) {%>
											<a href="javascript:void(0)" onclick="modifyComment(this,'<%=ncc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">수정</a>
											<a href="javascript:void(0)" onclick="deleteComment(this,'<%=ncc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">삭제</a>
											<%} %>
										</p>
										<%} %>
									</li>
								</ul>
							<%} %>
						<%} %>
					<%} //level==1 if문 종료지점%>
					
				<%} //댓글 for문 종료지점%>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function fileDownload(filename,filepath){
			var url = "/noticeFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			location.href=url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
		$(".recShow").click(function(){
			$(this).hide();
			var idx = $(".recShow").index(this);
			$(".recCancel").eq(idx).parents("div").css("display","block");
		});
		$(".recCancel").click(function(){
			var idx = $(".recCancel").index(this);
			$(this).parents(".re").css("display","none");
			$(".recShow").eq(idx).show();
		});
		
		function modifyComment(obj, commentNo, noticeNo){
			$(obj).parent().prev().show();//textarea
			$(obj).parent().prev().prev().hide();//p
			//수정버튼->수정완료
			$(obj).html('수정완료');
			$(obj).attr('onclick','modifyComplete(this,"'+commentNo+'","'+noticeNo+'")');
			//삭제버튼->수정취소
			$(obj).next().html('수정취소');
			$(obj).next().attr('onclick','modifyCancel(this,"'+commentNo+'","'+noticeNo+'")');
			//답글달기버튼
			$(obj).next().next().hide();
		}
		
		function modifyCancel(obj, commentNo, noticeNo){
			$(obj).parent().prev().hide();//textarea
			$(obj).parent().prev().prev().show();//p
			$(obj).prev().html('수정');
			$(obj).prev().attr('onclick','modifyComment(this,"'+commentNo+'","'+noticeNo+'")');
			$(obj).html('삭제');
			$(obj).attr('onclick','deleteComment(this,"'+commentNo+'","'+noticeNo+'")');
			$(obj).next().show();
		}
		function modifyComplete(obj, commentNo, noticeNo){
			var form = $("<form action='/noticeCommentUpdate' method='post'></form>");
			form.append($("<input type='text' name='noticeCommentNo' value='"+commentNo+"'>"));
			form.append($("<input type='text' name='noticeNo' value='"+noticeNo+"'>"));
			form.append($(obj).parent().prev());
			$("body").append(form);
			form.submit();
		}
		
		function deleteComment(obj, commentNo, noticeNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href="/noticeCommentDelete?noticeCommentNo="+commentNo+"&noticeNo="+noticeNo;
			}
		}
	</script>
</body>
</html>