<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    	String keyword = (String)request.getAttribute("keyword");
    	String type = (String)request.getAttribute("type");
    	System.out.println(keyword);
    	System.out.print(type);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<style>
		select.form-control,input.form-control{
			display:inline-block;
			width:200px;
			height:30px;
			font-size: 0.8em;
		}
	</style>
	<section>
		<div style="margin: 0 auto; width:80%;margin-top:100px;">
			<form action="/searchKeyword">
				<select name="type" class="form-control">
				<% if(type==null){ %>
					<option value="memId">아이디</option>					
					<option value="memName">이름</option>
				<%}else if(type.equals("memId")){%>
					<option value="memId" selected>아이디</option>					
					<option value="memName">이름</option>
				<%} else  if(type.equals("memName")){%>
					<option value="memId">아이디</option>					
					<option value="memName" selected>이름</option>
				<%} %>
				</select>
				<%if(keyword!=null){ %>
				<input type="text" class="form-control" name="keyword" value="<%=keyword%>">
				<%}else{ %>
				<input type="text" class="form-control" name="keyword">
				<%} %>				
				<button type="submit" class="btn btn-outline-secondary btn-sm">검색</button>
			</form>
		</div>
		<table class="table table-hover" style="width:80%;margin:0 auto; text-align:center;">
			<tr>
				<th>선택</th>
				<th>회원번호</th><th>아이디</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th><th>등급</th><th>등급변경</th>
			</tr>
			<%for(Member mem :list) {%>
			<%if(mem.getMemNo()!=m.getMemNo()){ %>
			<tr>
				<td><input type="checkbox" class="chk"></td>
				<td><%=mem.getMemNo() %></td>
				<td><%=mem.getMemId() %></td>
				<td><%=mem.getMemName() %></td>
				<td><%=mem.getPhone() %></td>
				<td><%=mem.getAddress() %></td>
				<td><%=mem.getEnrollDate() %></td>
				<td>
					<select>
					<%if(mem.getMemLevel()==1){ %>
						<option value="1" selected>관리자</option>
						<option value="2">정회원</option>
						<option value="3">준회원</option>
					<%}else if(mem.getMemLevel()==2){ %>
						<option value="1">관리자</option>
						<option value="2" selected>정회원</option>
						<option value="3">준회원</option>
					<%}else if(mem.getMemLevel()==3){ %>
						<option value="1">관리자</option>
						<option value="2">정회원</option>
						<option value="3" selected>준회원</option>
					<%} %>
					</select>
				</td>
				<td>
					<button class="btn btn-outline-info btn-sm changeBtn">변경</button>
				</td>
			</tr> 
			<%} %>
			<%} %>
			<tr>
				<th colspan="9">
					<button class="btn btn-info btn-lg changeAllBtn">변경하기</button>
				</th>
			</tr>
		</table>
	</section>
	<script type="text/javascript">
		$(".changeBtn").click(function(){
			var memLevel = $(this).parent().prev().children().val();
			//alert(memLevel);
			var memNo = $(this).parent().parent().children().first().next().html();
			//alert(memNo);
			location.href="/changeLevel?memNo="+memNo+"&memLevel="+memLevel;
		});
		$(".changeAllBtn").click(function(){
			var inputs = $("[type=checkbox]:checked");
			var num = new Array();
			var level = new Array();
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().parent().find("select").val());
			});
			//join으로 구분자를 삽입함
			location.href="/changeAllLevel?num="+num.join("/")+"&level="+level.join("/");
		});		
	</script>
</body>
</html>