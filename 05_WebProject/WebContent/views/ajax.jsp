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
		<div class="container" style="color:black;">
			<h3>1. Ajax로 서버에 전송값 보내기</h3>
			<p>버튼을 클릭하여 전송값 서버에서 출력</p>
			<input type="text" class="form-control" id="msg1">
			<button class="btn btn-primary" onclick="jsAjax();">보내기(JS)</button>
			<button class="btn btn-primary" id="jQ1">보내기(jQuery)</button>
			<hr>
			<h3>2. 버튼 클릭 시 서버에서 보낸 값 사용자가 수신</h3>
			<button class="btn btn-primary" id="jQ2">서버에서 보낸 값 확인</button>
			<p id="p2" class="border border-danger"></p>
			<h3>3. 서버로 기본형 전송값을 보내고, 결과받기</h3>
			<p>두 숫자를 보내고 그 합을 받음</p>
			<input type="text" id="firstNum"><br>
			<input type="text" id="secondNum"><br>
			<button class='btn btn-primary' id="jQ3">실행</button>
			<p id="p3" class="border border-danger"></p>
			<hr>
			<h3>4. 서버로 Object형 전송값을 보내고 결과처리</h3>
			이름 : <input type="text" id="name"><br>
			나이 : <input type="text" id="age"><br>
			주소 : <input type="text" id="addr"><br>
			<button class="btn btn-primary" id="jQ4">실행</button>
			<hr>
			<h3>5. 서버로 기본형 전송값을 보내고, 결과를 객체 받아서 처리</h3>
			<p>JSON사용</p>
			<p>유저 이름을 입력하여 해당하는 유저 정보를 가져오기</p>
			유저 이름 : <input type="text" id="userName"><br>
			<button class="btn btn-primary" id="jQ5">실행</button>
			<p id="p5" class="border border-danger"></p>
		</div>
	</section>
</body>
<script>
	function jsAjax(){
		//1.XMLHttpRequest객체생성
		var xhttp = new XMLHttpRequest();
		//입력값 가져오기
		var msg = document.getElementById("msg1").value;
		//2.요청정보 (설정 방식,url,비동기여부)
		xhttp.open("GET","/ajaxTest1?msg="+msg,true);
		//3.데이터 처리에 따라 작동할 함수
		xhttp.onreadystatechange = function(){
			//정상처리시
			if(this.readyState == 4 && this.status == 200){
				console.log("서버 전송 성공");
			}
			//페이지가 없을때 404error
			else if(this.readyState == 4 && this.status == 404){
				console.log("서버 전송 실패");
			}
		};
		//4.서버에 전송
		xhttp.send();
	}
	$("#jQ1").click(function(){
		var msg = $("#msg1").val();
		$.ajax({
			url : "/ajaxTest1",
			data : {msg:msg},
			type : "get",
			success : function(){
				console.log("서버 전송 성공");
			},
			error : function(){
				console.log("서버 전송 실패");
			},
			complete : function(){
				console.log("무조건 호출");
			}
		});
	});
	$("#jQ2").click(function(){
		$.ajax({
			url : "/ajaxTest2",
			type : "get",
			success : function(data){
				$("#p2").html(data);
			},
			error : function(){
				console.log("실패");
			}
		});
	});
	$("#jQ3").click(function(){
		var first = $("#firstNum").val();
		var second = $("#secondNum").val();
		$.ajax({
			url : "/ajaxTest3",
			data : {first:first,second:second},
			type : "post",
			success : function(data){
				$("#p3").html(data);
			}
		});
	});
	$("#jQ4").click(function(){
		var name = $("#name").val();
		var age = $("#age").val();
		var addr = $("#addr").val();
		var user = {name:name,age:age,addr:addr};
		$.ajax({
			url:"/ajaxTest4",
			type:"post",
			data:user,
			success:function(){
				console.log("성공");
			}
		});
	});
	$("#jQ5").click(function(){
		var name = $("#userName").val();	
		$.ajax({
			url:"/ajaxTest5",
			type:"get",
			data:{name:name},
			success:function(data){
				//data는 JSON형태(객체형태)
				var name=decodeURIComponent(data.name);
				var age=data.age;
				var addr=decodeURIComponent(data.addr);
				$("#p5").html("이름 : "+name+"<br>나이 : "+age+"<br>주소 : "+addr);
			}
		});
	});
</script>
</html>
