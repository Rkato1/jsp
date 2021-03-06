<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member m = (Member)session.getAttribute("member");
    %>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>
<header class="header_area">
	<div class="main_menu">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<!-- a href="navbar-brand logo_h" href="/"-->
				<a href="/">
					<img src="/img/logo.png" width="165" height="80">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-labl="Toggle navigation">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
					<ul class="nav navbar-nav menu_nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="/noticeList?reqPage=1">공지사항</a></li>
						<li class="nav-item"><a class="nav-link" href="/boardList?reqPage=1">게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="/views/ajax.jsp">ajax</a></li>
						<li class="nav-item"><a class="nav-link" href="/photoList">사진게시판</a></li>
						<li class="nav-item"><a class="nav-link" href="/views/api.jsp">API</a></li>
					</ul>
				</div>
				<div class="right-button">
					<ul>
						<%if(m == null){ %>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/login.jsp'">로그인</button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/join.jsp'">회원가입</button></li>
						<%}else {%>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/myPage?memId=<%=m.getMemId() %>'"><%=m.getMemId() %></button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/logout'">로그아웃</button></li>
						<%} %>
					</ul>
				</div>
			</div>			
		</nav>
	</div>
</header>