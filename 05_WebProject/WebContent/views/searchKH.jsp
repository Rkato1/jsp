<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<title>학원 조회 페이지</title>
</head>
<body>
<h1>학원 정보 조회하기</h1>
<hr>
<input type="text" name="nameSearch"><button type="button" id="btnSearch">조회하기</button>
<p id="p1"></p>
</body>
<script type="text/javascript">
$("#btnSearch").click(function(e){
	var text = $("input[name=nameSearch]").val();
	$.ajax({
		url:"/searchKH",
		type:"get",
		data:{text:text},
		success:function(data){
			var khName=decodeURIComponent(data.khName);
			var no=data.no;
			var addr=decodeURIComponent(data.addr);
			var fax=decodeURIComponent(data.fax);
			$("#p1").html("<ul><li>"+khName+"</li><li>"+addr+"</li><li>"+fax+"</li></ul>");	
		},error:function(){
			$("#p1").html("<ul><li>정보가 없습니다.</li></ul>");
		}
	});
});
</script>
</html>