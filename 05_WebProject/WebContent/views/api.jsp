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
	<div class="div-wrapper" style="width:80%; margin:0 auto;">
			<h2>1. 메일보내기</h2>
			<input type="text" id="mail">
			<button id="mailBtn" class="btn btn-primary">메일전송</button>
			<input type="text" id="mailCode" style="display:none;">
			<button id="mailChk" class="btn btn-primay" style="display:none;">확인</button>
			<span id="mailMsg"></span>
	</div>
</section>
<script type="text/javascript">
	var mailCode="";
	$("#mailBtn").click(function(){
		var email=$("#mail").val();
		$.ajax({
			url:"/sendMail",
			type:"post",
			data:{email:email},
			success:function(data){
				console.log(data);
				mailCode=data;
				$("#mailCode").show();
				$("#mailChk").show();
			}
		});
	});
</script>
</body>
</html>