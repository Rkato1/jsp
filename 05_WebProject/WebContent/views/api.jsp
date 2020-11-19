<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //http://postcode.map.daum.net/guide
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 다음API(주소찾기) -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- NaverAPI(지도) -->
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=q2af1gt9af&submodules=geocoder"></script>
<!-- 결제모듈 API(iamport) -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 영화API -->
<script type="text/javascript" src=""></script>


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
		<h2>2. 다음 주소찾기 API</h2>
		<ul>
			<li>
				<input id="postCode" style="width:200px;display:inline-block;" type="text" placeholder="우편번호" class="form-control" readonly>
				<button id="addrSearchBtn" type="button" onclick="addrSearch();" class="btn btn-primary">주소검색</button>
			</li>
			<li>
				<input type="text" id="roadAddr" style="width:400px;display:inline-block;" placeholder="도로명주소" class="form-control" readonly>
				<input type="text" id="jibunAddr" style="width:400px;display:inline-block;" placeholder="지번주소" class="form-control" readonly>
			</li>
			<li>
				<input id="detailAddr" style="width:800px; display:inline-block" type="text" placeholder="상세주소" class="form-control">
			</li>
		</ul>
		<h2>3. 네이버 지도</h2>
		<div id="map" style="width:100%;height:500px"></div>
		<hr>
		<h2>4. 결제 모듈 API(아임포트)</h2>
		<div id="pay">
			<h4>
				<label><input type="checkbox" value="1000">1000원</label>
				<label><input type="checkbox" value="5000">5000원</label>
				<label><input type="checkbox" value="10000">10000원</label>
				<label><input type="checkbox" value="50000">50000원</label>
			</h4>
			<h3>총 결제 금액 <span></span>원</h3>
			<button class="btn btn-danger">결제하기</button>
			<p id="paymentResult"></p>
		</div>
		<hr>
		<h2>5. 영화 순위 검색</h2>
		<input type="text" id="movieDate" placeholder="20201119">
		<button id="movieBtn" type="button" class="btn btn-primary">영화 순위 검색</button>
		<div id="movieResult"></div>
	</div>	
</section>
<script type="text/javascript">
	$("#movieBtn").click(function(){
		var date = $("#movieDate").val();
		$.ajax({
			url:"/movieRank",
			data:{date:date},
			type:"get",
			dataType:"json",
			success:function(data){
				//console.log(data);
				$("#movieResult").empty();
				var table = $("<table class='table table-bordered'></table>");
				var titleTr = $("<tr></tr>");
				titleTr.append($("<th>순위</th>"));
				titleTr.append($("<th>영화제목</th>"));
				titleTr.append($("<th>개봉일</th>"));
				table.append(titleTr);
				for(var i in data){
					//console.log(i);
					var tr = $("<tr></tr>");
					tr.append($("<td>"+data[i].rank+"</td>"));
					tr.append($("<td>"+data[i].movieName+"</td>"));
					tr.append($("<td>"+data[i].openDate+"</td>"));
					table.append(tr);
				}
				$("#movieResult").append(table);
			}
		});
	});
	$(function(){
		var totalPay=0;
		$("#pay input").change(function(){
			if($(this).is(":checked")){
				totalPay += (Number)($(this).val());
			}else{
				totalPay -= (Number)($(this).val());
			}
			$("#pay span").html(totalPay);
		});
		$("#pay button").click(function(){
			var price = $("#pay span").html();
			var d = new Date();
			var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes+''+d.getSeconds();
			//결제API 코드
			IMP.init("imp64274083");
			IMP.request_pay({
				//상점 거래 ID
				merchant_uid:'상품명_'+date,
				//결제 이름
				name:"결제테스트",
				//가격
				amount:price,
				//구매자 email
				buyer_email:'silvestr@naver.com',
				//구매자 이름
				buyer_name:"김현식",
				//구매자 전화번호
				buyer_tel:"010-4948-6670",
				//구매자 주소
				buyer_addr:"임시 테스트 중임",
				//우편번호
				buyer_postcode:"123-456"
			},function(rsp){
				//결제가 성공한 경우
				if(rsp.success){
					var r1="고유 ID : "+rsp.imp_uid;
					var r2="상점거래아이디 : "+rsp.merchant_uid;
					var r3="결제금액 : "+rsp.paid_amount;
					var r4="카드승인번호 : "+rsp.apply_num;
					$("#paymentResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
				}else{
					$("#paymentResult").html("결제 실패 사유 : "+rsp.error_msg);
				}
			});
		});
	});

	window.onload=function(){
		//div id="map"
		//아무값도 지정하지 않고 지도 객체를 불러오면 서울시청 중심으로 불러와짐
		//var map = new naver.maps.Map("map");
		var map = new naver.maps.Map("map",{
			//중심좌표설정
			center : new naver.maps.LatLng(37.533807,126.896772),
			//확대비율
			zoom: 18,
			//zoom컨트롤러
			zoomControl:true,
			zoomControlOptions :{
				//위치이동
				position:naver.maps.Position.TOP_RIGHT,
				//기본값
				//style : naver.maps.ZoomControlStyle.LARGE
				//+-버튼만 존재하게 바꾸기
				style : naver.maps.ZoomControlStyle.SMALL
			}
		});
		
		//마커추가
		var marker = new naver.maps.Marker({
			//마커의 위치
			position : new naver.maps.LatLng(37.533807,126.896772),
			//마커가 들어갈 지도 설정(위의 지도 변수)
			map : map
		});
		//지도에 클릭이벤트 추가
		naver.maps.Event.addListener(map,"click",function(e){
			//마커이동
			marker.setPosition(e.coord);
			if(infoWindow != null){
				infoWindow.close();
			}
			//위경도 좌표를 주소로 가져오는 기능 reverseGeocode->submodul추가해야사용가능
			naver.maps.Service.reverseGeocode({
				//각각 위도 경도
				location : new naver.maps.LatLng(e.coord.lat(),e.coord.lng())				
			},function(status, response){
				if(status != naver.maps.Service.Status.OK){
					return alert("주소검색오류");
				}
				var result = response.result;
				//json형태로 주소값을 가지고 옴
				var item=result.items;
				//0번이 지번, 1번이 도로명
				var address=item[1].address;
				contentString = [
					'<div class="iw_inner">',
					'<p>'+address+"</p>",
					'</div>'
				].join('');
				
			});
		});
		//html태그 쓰기 귀찮으니 join을 활용해 ('')제거 하나로 합치는 개념
		var contentString=[
			'<div class="iw_inner">',
			'	<h3>KH정보교육원</h3>',
			'	<p>서울시 영등포구 선유2로 57 이레빌딩 19F, 20F</p>',
			'<div>'
		].join('');
		
		var infoWindow=new naver.maps.InfoWindow();
		//마커 클릭시 정보 나왔다 사라지기
		naver.maps.Event.addListener(marker,'click',function(e){
			//현재 정보창이 열려있으면
			if(infoWindow.getMap()){
				infoWindow.close();
			}
			//그렇지 않다면
			else{
				infoWindow = new naver.maps.InfoWindow({				
					content:contentString
				});
				infoWindow.open(map,marker);				
			}
		});
		
	}
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
	$("#mailChk").click(function(){
		if($("#mailCode").val() == mailCode){
			$("#mailMsg").html("인증성공");
			$("#mailMsg").css("color","green");
		}else{
			$("#mailMsg").html("인증실패");
			$("#mailMsg").css("color","red");
		}
	});
	function addrSearch(){
		new daum.Postcode({
			oncomplete:function(data){
				//검색해서 선택한 결과가 data라는 매개변수를 통해서 들어옴
				//다양값이 들어오지만 그 중 3개 값만 사용
				$("#postCode").val(data.zonecode);
				$("#roadAddr").val(data.roadAddress);
				$("#jibunAddr").val(data.jibunAddress);
				$("#detailAddr").focus();
			}
		}).open();
	}
</script>
</body>
</html>