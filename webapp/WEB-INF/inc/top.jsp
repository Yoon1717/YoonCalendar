<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i"
	rel="stylesheet" />
	
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap" rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/stylesboot.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>


<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
	<div class="container">
		<a class="navbar-brand text-uppercase fw-bold d-lg-none"
			href="index.html">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item px-lg-4"><a class="nav-link text-uppercase"
					href="${pageContext.request.contextPath}/">Home</a></li>
				<!-- 로그인 전 -->
				<c:if test="${sessionScope.login ==null}">
				<li class="nav-item px-lg-4"><a class="nav-link text-uppercase"
					href="${pageContext.request.contextPath}/loginView">로그인</a></li>
				<li class="nav-item px-lg-4"><a class="nav-link text-uppercase"
					href="${pageContext.request.contextPath}/registView">회원가입</a></li>
				</c:if>
				<!-- 로그인 후 -->
				<c:if test="${sessionScope.login !=null}">
				<li class="nav-item px-lg-4"><a class="nav-link text-uppercase"
					href="${pageContext.request.contextPath}/mypage">${sessionScope.login.memNm}님</a></li>
				<!-- 노래추천 페이지& 일기 기록 보는  -->
				<li class="nav-item px-lg-4"><a class="nav-link text-uppercase"
					href="${pageContext.request.contextPath}/logoutDo">로그아웃</a></li>
				</c:if>
				
				
					
					
			</ul>
		</div>
	</div>
</nav>

