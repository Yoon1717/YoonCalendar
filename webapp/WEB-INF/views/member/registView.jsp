<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<!-- 모든 화면에 포함시키는 부분 -->

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">회원가입</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<form method="post" action="<c:url value="/registDo"/>">
						<div class="form-floating mb-3">
							<input class="form-control" name="id" , type="text"
								placeholder="아이디를 입력해주세요"> <label>아이디</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" name="pw" , type="password"
								placeholder="비밀번호를 입력해주세요"> <label>비밀번호</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" name="nm" , type="text"
								placeholder="이름을 입력해주세요"> <label>이름</label>
						</div>
						<button class="btn btn-primary btn-xL" type="submit">가입하기</
						
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/footer.jsp"%>
	<!-- 모든 화면에 포함시키는 부분 -->
</body>
</html>