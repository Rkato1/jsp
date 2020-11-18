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
			<hr>
			<h3>6. 서버로 기본형 전송값을 보내고, 결과를 리스트 객체 받아서 처리</h3>
			<p>JSON사용</p>
			<p>유저 이름을 입력하여 해당 유저 정보를 가져오기 -> 유저가 없으면 전체 리스트 가져오기</p>
			유저 이름 : <input type="text" id="userName2"><br>
			<button class="btn btn-primary" id="jQ6">실행</button>
			<p id="p6" class="border border-danger"></p>
			<hr>
			<h3>7. 서버로 기본형 전송값을 보내고, 결과를 맵 객체 받아서 처리</h3>
			<p>JSON사용</p>
			<p>유저 이름을 입력하여 해당 유저 정보를 가져오기 -> 유저가 없으면 전체 리스트를 맵 형태로 가져오기</p>
			유저 이름 : <input type="text" id="userName3"><br>
			<button class="btn btn-primary" id="jQ7">실행</button>
			<p id="p7" class="border border-danger"></p>
			<hr>
			<h3>8. GSON을 이용한 리스트 반환</h3>
			<p>GSON</p>
			<button class="btn btn-primary" id="jQ8">실행</button>
			<p id="p8" class="border border-danger"></p>
			<h3>9. GSON을 이용한 맵 반환</h3>
			<p>GSON</p>
			<button class="btn btn-primary" id="jQ9">실행</button>
			<p id="p9" class="border border-danger"></p>
			<hr>
			<h3>10. ajax를 이용한 selectbox</h3>
			<select id="sel1">
				<option value="서울" selected>서울</option>
				<option value="경기도">경기도</option>
			</select>
			<select id="sel2">
				
			</select>			
		</div>
	</section>
</body>
<script>
	$(function(){
		changeSel();	
	});
	$("#sel1").change(function(){
		changeSel();
	});
	function changeSel(){
		var sel = $("#sel1").val();
		$.ajax({
			url:"/selAddr",
			type:"get",
			data:{sel:sel},
			success:function(data){
				var sel2 = $("#sel2");
				//초기화
				sel2.empty();
				for(var i in data){
					var option = $("<option></option>");
					//데이터처리할 값
					option.val(data[i]);
					//보여줄값
					option.html(data[i]);
					//자식으로 추가
					sel2.append(option);
				}
			}
		});
	}
	
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
	
	$("#jQ6").click(function(){
		var name = $("#userName2").val();	
		$.ajax({
			url:"/ajaxTest6",
			type:"post",
			//param이름,값
			data:{name:name},
			success:function(data){
				//data는 JSONArray형태(객체배열형태)
				var resultHtml="";
				for(var i=0;i<data.length;i++){
					var name=decodeURIComponent(data[i].name);
					var age=data[i].age;
					var addr=decodeURIComponent(data[i].addr);
					resultHtml += "이름 : "+name+" / 나이 : "+age+" / 주소 : "+addr+"<br>";
				}
				$("#p6").html(resultHtml);
			}
		});
	});
	
	$("#jQ7").click(function(){
		var name = $("#userName3").val();
		$.ajax({
			url:"/ajaxTest7",
			type:"post",
			//param이름,값
			data:{name:name},
			success:function(data){
				//data->map->JSON
				var resultHtml="";
				//전체키값(배열형태로 리턴)
				var keys = Object.keys(data);
				for(var i=0;i<keys.length;i++){
					var key=keys[i];
					var name=decodeURIComponent(data[key].name);
					var age=data[key].age;
					var addr=decodeURIComponent(data[key].addr);
					resultHtml += "이름 : "+name+" / 나이 : "+age+" / 주소 : "+addr+"<br>";
				}
				$("#p7").html(resultHtml);
			}
		});
	});
	
	$("#jQ8").click(function(){		
		$.ajax({
			url:"/ajaxTest8",
			type:"get",
			success:function(data){
				var resultHtml="";				
				for(var index in data){					
					resultHtml += "이름 : "+data[index].name+" / 나이 : "+data[index].age+" / 주소 : "+data[index].addr+"<br>";
				}
				$("#p8").html(resultHtml);
			}
		});
	});
	
	$("#jQ9").click(function(){		
		$.ajax({
			url:"/ajaxTest9",
			type:"get",
			success:function(data){
				//data->map->JSON
				var resultHtml="";				
				for(var key in data){					
					resultHtml += "이름 : "+data[key].name+" / 나이 : "+data[key].age+" / 주소 : "+data[key].addr+"<br>";
				}
				$("#p9").html(resultHtml);
			}
		});
	});
</script>
</html>
