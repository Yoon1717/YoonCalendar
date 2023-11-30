<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
   <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
</head>
<body>

	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<!-- 모든 화면에 포함시키는 부분 -->
			<!-- Contact Section Heading-->
        <h1 class="site-heading text-center text-faded d-none d-lg-block">
            <span class="site-heading-upper text-primary mb-3">Leave your day</span> 
        </h1>

	<section class="page-section" id="contact">
		<div class="container">
			
			
			
    <!-- Content Row ========================================================-->
    <div class="row" style="margin-top: 30px;">
	    
		<!-- 상단 바 -->
		<div class="row">
		  <!-- 날짜 이동 아이콘 -->
		  <div class="col-4">
			<form action="<c:url value="/boardEditDo" />" method="post">
			    <div class="btn-group" role="group" aria-label="Basic outlined example">
			      <button id="prevButton" type="button" class="btn btn-outline-primary"> &lt; </button>
			      <button id="todayButton" type="button" class="btn btn-outline-primary">Today</button>
			      <button id="nextButton" type="button" class="btn btn-outline-primary"> &gt; </button>
			    </div>
			</form>
		  </div>
		  <!-- 출력중인 날짜 -->
		  <div class="col-4 text-center">
		    <div class="fc-toolbar-chunk">
		      <div id="dateDisplay" class="fc-toolbar-title" style="color: white; font-size:25px;"></div>
		    </div> 
		  </div>
		  <!-- Year, Month, Week, Day 단위 버튼 -->
		  <!-- <div class="col-4 d-flex justify-content-end">
		    <div class="btn-group" role="group" aria-label="Basic outlined example">
		      <button type="button" class="btn btn-outline-primary">Year</button>
		      <button type="button" class="btn btn-outline-primary">Month</button>
		      <button type="button" class="btn btn-outline-primary">Week</button>
		      <button type="button" class="btn btn-outline-primary">Day</button>
		    </div>
		  </div> -->
		</div>
		
		<hr><!-- 투명선이든 마진이든 수정필요 -->
		
		<!-- Project Card Example -->
        <div class="col-xl-8 col-lg-7">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">My Icon</h6>
                </div>
                <div class="card-body">
					<c:forEach items="${countCldPerIcon }" var="icon">
	                    <h4 class="small font-weight-bold" style="font-size: 20px">
		                    <img src="${pageContext.request.contextPath }${icon.ICON_IMG }" class="card-body-img" style="width: 40px; height: 40px;">
		                    ${icon.ICON_COMMENT} 
		                    <span class="float-right" style="float: right;">${icon.COUNTCLDPERICON}</span>
	                    </h4>
	                    <div class="progress mb-4">
	                        <div class="progress-bar bg-danger" 
	                        	role="progressbar" 
	                        	style="width: ${icon.COUNTCLDPERICON}%" 
	                        	aria-valuenow="${icon.COUNTCLDPERICON}"
	                            aria-valuemin="0" 
	                            aria-valuemax="100">
	                        </div>
	                    </div>
					</c:forEach>
                </div>
            </div>
        </div>
<%-- 
        <!-- Pie Chart ------------------------------------------------->
        <div class="col-xl-4 col-lg-5">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Icon Percent</h6>
                    <!-- <div class="dropdown no-arrow">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                            aria-labelledby="dropdownMenuLink">
                            <div class="dropdown-header">Dropdown Header:</div>
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </div> -->
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-pie pt-4 pb-2">
                        <canvas id="myPieChart"></canvas>
                    </div>
                    <!-- 하단 글씨 왜있는지모름 -->
                    <!-- <div class="mt-4 text-center small">
                        <span class="mr-2">
                            <i class="fas fa-circle text-primary"></i> Direct
                        </span>
                        <span class="mr-2">
                            <i class="fas fa-circle text-success"></i> Social
                        </span>
                        <span class="mr-2">
                            <i class="fas fa-circle text-info"></i> Referral
                        </span>
                    </div> -->
                </div>
            </div>
        </div>
    </div>
 --%>

    <!-- Content Row ========================================================================-->
    <div class="row">

        <!-- Area Chart --------------------------------------------------------------------->
        <div class="col-xl-8 col-lg-7">
            <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                    <h6 class="m-0 font-weight-bold text-primary">Earnings Overview</h6>
                    <div class="dropdown no-arrow">
                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                            aria-labelledby="dropdownMenuLink">
                            <div class="dropdown-header">Dropdown Header:</div>
                            <a class="dropdown-item" href="#">Action</a>
                            <a class="dropdown-item" href="#">Another action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                    <div class="chart-area">
                        <canvas id="myAreaChart"></canvas>
                    </div>
                </div>
            </div>
        </div>

    </div> 
			

		</div>
	</section>
	
	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/footer.jsp"%>
	<!-- 모든 화면에 포함시키는 부분 -->
	
	 <script src="js/Chart.min.js"></script>
	 <script src="js/chart-area-demo.js"></script>
	 <script src="js/chart-bar-demo.js"></script>
	 <script src="js/chart-pie-demo.js"></script>
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			const dateDisplay = document.getElementById("dateDisplay");
			const prevButton = document.getElementById("prevButton");
			const todayButton = document.getElementById("todayButton");
			const nextButton = document.getElementById("nextButton");

			let currentDate = new Date(); // Initialize with today's date
			console.log(currentDate);

			function updateDateDisplay() {
				dateDisplay.innerText = currentDate.toDateString();
			}

			prevButton.addEventListener("click", function() {
				currentDate.setDate(currentDate.getDate() - 1);
				updateDateDisplay();
				console.log(updateDateDisplay);
				console.log(currentDate);
				// Make an AJAX request to the server with the new date
				// Retrieve and display data from the server based on the date
			});

			todayButton.addEventListener("click", function() {
				currentDate = new Date(); // Reset to today's date
				updateDateDisplay();
				console.log(updateDateDisplay);
				console.log(currentDate);
				// Make an AJAX request to the server with the new date
				// Retrieve and display data from the server based on the date
			});

			nextButton.addEventListener("click", function() {
				currentDate.setDate(currentDate.getDate() + 1);
				updateDateDisplay();
				console.log(updateDateDisplay);
				console.log(currentDate);
				// Make an AJAX request to the server with the new date
				// Retrieve and display data from the server based on the date
			});
			
			updateDateDisplay();
		});
	</script>


</body>
</html>