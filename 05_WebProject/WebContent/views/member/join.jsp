<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container" style="margin:0 auto; width:80%; color:black; text-align:center;">
			<form name="checkIdForm">
				<input type="hidden" name="checkId">
			</form>
			<form action="/join" method="post" id="memberJoin">
				<h1>회원가입</h1>
				<table class="table">
					<tr>
						<th><label for="memId">아이디</label></th>
						<td><input type="text" name="memId" id ="memId" class="form-control">
						<!-- button태그는 기본값이 submit -->
						<!-- <td style="width:150px"><button class="btn btn-primary" onclick="checkId();" type="button">중복체크</button></td-->
						<td style="width:250px;"><span id="idChkMsg"></span></td>
					</tr>
					<tr>
						<th><label for="memPw">비밀번호</label></th>
						<td><input type="password" name="memPw" id ="memPw" class="form-control">
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="memPwRe">비밀번호 확인</label></th>
						<td><input type="password" id ="memPwRe" class="form-control">
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="memName">이름</label></th>
						<td><input type="text" name="memName" id ="memName" class="form-control">
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="phone">전화번호</label></th>
						<td><input type="text" name="phone" id ="phone" class="form-control">
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="address">주소</label></th>
						<td><input type="text" name="address" id ="address" class="form-control">						
						<td style="width:150px;"></td>
					</tr>
				</table>
				<hr>
				<div id="btn-box">
					<button class="btn btn-success btn-lg" type="submit">회원가입</button>
					<button class="btn btn-success btn-lg" type="reset">초기화</button>
				</div>
			</form>
		</div>
	</section>
	<script>
		function checkId(){
			var memId = $("#memId").val();
			if(memId==""){
				alert("아이디를 입력하세요");
				return;
			}
			var url = "/checkId";//아이디 중복체크용 서블릿 url mapping값
			var title = "checkId";
			var status = "left=500px, top=100px, width=300px, height=200px, menubar=no, status=no, scrollbars=yes";
			var popup = window.open("",title,status);
			//숨겨둔 input의 value속성에 사용자가 입력한 아이디값 대입
			$("[name=checkId]").val(memId);
			var checkForm = $("[name=checkIdForm]");
			//팝업창과 폼태그를 연결하는 속성
			checkForm.attr("target", title);
			//target으로 새창으로 띄울지 기존창에서 띄울지 결정할 수 있음
			checkForm.attr("action", url);
			//이동할 목적지
			checkForm.submit();
		}
		$("#memId").keyup(function(){
			var memId = $(this).val();
			$.ajax({
				url:"/ajaxCheckId",
				type:"get",
				data:{memId:memId},
				success:function(data){
					var msg = $("#idChkMsg");
					if(data==1){
						msg.html('사용가능');
						msg.css('color','green');
					}else{
						msg.html('사용불가');
						msg.css('color','red');
					}
				}
			});
		});
	</script>
</body>
</html>