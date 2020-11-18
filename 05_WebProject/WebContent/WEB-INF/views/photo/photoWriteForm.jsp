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
	<div class="table-wrapper" style="text-align:center;width:80%;margin:0 auto;">
		<form action="/insertPhoto" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">사진게시판 작성</th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=m.getMemId() %><input type="hidden" name="photoWriter" value="<%=m.getMemId() %>"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="filename" onchange="loadImg(this)"></td>
				</tr>
				<tr>
					<th>이미지 보기</th>
					<td>
						<div id="img-viewer">
							<img id="img-view" width="350">
						</div>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="3" name="photoContent" class="form-control"></textarea></td>
				</tr>
				<tr style="text-align:center;">
					<th colspan="2">
						<button type="submit" class="btn btn-outline-info">등록하기</button>
					</th>
				</tr>
			</table>
		</form>
	</div>	
</section>
</body>
<script type="text/javascript">
	function loadImg(f){
		//배열의 길이가 0인지(첨부파일 갯수가 0인지 확인),1번째
		//배열에 담겨있는 파일의 크기가 0인지,2번째 -> 파일 업로드를 1개만 하기 때문에 0 인덱스만 검사
		if(f.files.length!=0 && f.files[0]!=0){
			//JSFileReader->파일 정보 확인 가능
			var reader = new FileReader();
			//현재 사용자가 선택한 파일의 경로를 읽어옴
			reader.readAsDataURL(f.files[0]);
			//파일의 경로를 읽어오는 작업이 완료되면
			reader.onload=function(e){
				//파일 경로를 src속성에 설정
				$("#img-view").attr('src',e.target.result);
			}
		}else{
			$("#img-view").attr('src',"");
		}
	}
</script>
</html>