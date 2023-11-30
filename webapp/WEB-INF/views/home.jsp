<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List" %>
<%@ page import="com.calendar.yoony.cld.vo.CldVO" %>


<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
    <link href="css/stylesmainpage.css" rel="stylesheet" />
    <title>YoonyDiary</title>
</head>

<body id="page-top">

	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/top.jsp"%>
	<!-- 모든 화면에 포함시키는 부분 -->

    <header>
        <h1 class="site-heading text-center text-faded d-none d-lg-block">
            <span class="site-heading-upper text-primary mb-3">Leave your day</span> <span class="site-heading-lower">Yoony</span>
        </h1>
    </header>

    <div class="containermy">
        <div class="box-a">
            <!-- 좌측 박스 -->
            <div id='calendar'></div>
        </div>

        <!-- 우측 박스 -->
        <div class="box-b">
            <!-- 아이콘 등록 부분 -->
            <!-- 추가할 데이터가 생긴다면 form에 작성!!!  -->
            <form id="iconForm" action="<c:url value=" /writeIconDo" />" method="post" enctype="multipart/form-data">
            <!-- cotroller writeIconDo 생성필요함 -->
	            <div class="input-container">
	                <!-- input 관련 스크립트 boardDetailView 댓글부분 참조 -->
	                <div class="col-lg-9">
	                    <input type="file" id="image-upload" name="uploadImage" accept="image/*"
	                        style="flex:4; margin-right:10px;">
	                    <input type="text" id="comment-input" name="iconComment" placeholder="코멘트를 입력하세요"
	                        style="flex: 4; margin-right: 10px;">
	                    <input type="hidden" name="memId" value="${sessionScope.login.memId }" id="memId">
	                </div>
	                <div class="col-lg-3">
	                    <button id="save-button" type="button" class="btn btn-info-me-2"
	                        onclick="fn_icon('${sessionScope.login.memId }'); "
	                        style="flex: 1; color: rgb(251, 237, 219); border: none; padding: 10px; cursor: pointer;">등록</button>
	                </div>
	            </div>
            </form>

            <!-- 등록한 아이콘 출력부분 -->
	            <div class="all-saved-item">
	                <!-- 새롭게 추가하는 아이콘 -->
	                <!-- <div class="saved-items" id="savedItems"> </div> -->
	                <table class="table">
	                    <tbody id="iconBody">
	                        <c:forEach items="${getHomeIcon }" var="icon">
	                            <tr id="${icon.iconNo }">
	                                <td>
	                                    <img src="${pageContext.request.contextPath }${icon.iconImg }" class="img icon-image"
	                                        style="cursor:pointer; width: 40px; height: 40px; margin-left: 7px; ">
	                                </td>
	                                <td style="color: rgb(251, 237, 219); font-size: 15px;" class="icon-comment">${icon.iconComment }
	                                </td>
	                                <!-- 삭제버튼 -->
	                                <td style="color: rgb(251, 237, 219);"><a onclick="fn_del_icon('${icon.iconNo}')">X</a>
	                                </td>
	                            </tr>
	                        </c:forEach>
	                    </tbody>
	                </table>
	            </div>
          <!--   </form> -->
        </div>
    </div>

	<!-- 모든 화면에 포함시키는 부분 -->
	<%@include file="/WEB-INF/inc/footer.jsp"%>

<script type="text/javascript">
        var calendar;
        const imageUploadInput = document.getElementById("image-upload");
        const commentInput = document.getElementById("comment-input");
      /*   const saveButton = document.getElementById("save-button");
        const savedItems = document.querySelector(".saved-items"); */
        // 현재 시간을 가져옴
        var currentTime = new Date();
        // 시간을 1시간 단위로 설정
        currentTime.setMinutes(0);
        currentTime.setSeconds(0);
        var isoTime = currentTime.toISOString();

        $(document).ready(function () {
        	$(document).on('click', '#iconBody .icon-image', function(){
//             $("#iconBody .icon-image").click(function () {
            	console.log($(this).parent());
                /* var comment = $(this).find("td:nth-child(2)").text(); */
                console.log('test',$(this).parent().parent());
                var comment = $(this).parent().parent().find('.icon-comment').text();
                /* let make_img = $(this).find("img").clone(); */
                let formdata = {
                    memId: $("#memId").val()
                    , iconNo: $(this).parent().parent().attr("id")
                    , iconComment: comment
                }
                console.log("memId: " + formdata.memId);
                console.log("iconNo: " + formdata.iconNo);
                console.log("iconComment: " + formdata.iconComment);
                $.ajax({
                    url: '<c:url value="writeCldDo/" />'
                    , type: 'POST'
                    /* post 방식으로 보낼 컨텐츠 타입 */
                    , contentType: 'application/json'
                    , dataType: 'json'
                    , data: JSON.stringify(formdata)
                    , success: function (res) {
                        console.log(res);
                    }, error: function (e) {
                        console.log(e);
                    }
                });



                /* console.log($(this).find("img")); */
                const checkEvent = {
                    title: comment,
                    start: isoTime,
                    /* img: '${pageContext.request.contextPath }/assets/img/dog.jpg' */
                    /* imageurl: $(make_img).attr('src') */
                };
                /* console.log(checkEvent); */
                calendar.addEvent(checkEvent);
            });
            /* 기존에 새로생성한 아이콘의 클릭이벤트
            savedItems.addEventListener("click", function (event) {
                const target = event.target;
                if (target.tagName === "IMG") {
                    const checkEvent = {
                        title: target.parentElement.querySelector(".comment-item").textContent,
                        start: isoTime
                    };
                    calendar.addEvent(checkEvent);
                }
            }); */
        });

        document.addEventListener('DOMContentLoaded', function () {
            // FullCalendar 코드
            var calendarEl = document.getElementById('calendar');
            calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'timeGridDay',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: ''
                },
                events: function (fetchInfo, successCallback, failureCallback) {
                    // 이벤트 데이터를 서버에서 비동기적으로 가져옴
                    $.ajax({
                        url: '<c:url value="/getHomeCLD" />', // 서버에서 일정 데이터를 가져올 엔드포인트
                        type: 'GET',
                        dataType: 'json', // 가져온 데이터 형식에 따라 조정
                        success: function (data) {
                            // 서버에서 받은 데이터를 FullCalendar에 추가
                            var events = data.map(function (eventData) {
                                return {
                                    title: eventData.iconComment, // 이벤트 제목
                                    start: eventData.cldTime // 이벤트 시작 시간 (날짜 및 시간 형식)
                                };
                            });
                            successCallback(events);
                        },
                        error: function (error) {
                            console.error('일정 데이터를 가져오는 중 오류 발생:', error);
                            failureCallback(error);
                        }
                    });
                },


                eventClick: function (res) {
                    let action = prompt("지울까 : Y/y");
                    if (action == 'Y' || action == 'y') {
                        res.event.remove();
                    } else { }
                },
            });
            calendar.render();
        });

        /* 로그인 후 이미지&아이콘을 등록, DB에 저장 */
        function fn_icon(p_id) {
			    if (p_id == '') {
			        alert("아이콘 등록은 로그인 이후 작성가능합니다");
			        location.href = '<c:url value="/loginView" />';
			        return;
			    }
			    const imageFile = imageUploadInput.files[0];
			    const comment = commentInput.value;
			    if (!(imageFile && comment)) {
			        alert("이미지와 코멘트를 모두 입력하세요.");
			        return;
			    }
			    let formData = new FormData($('#iconForm')[0]);
			    $.ajax({
			        url: '<c:url value="/files/upload" />',
			        type: 'POST',
			        data: formData,
			        dataType: 'json',
			        processData: false,
			        contentType: false,
			        success: function (res) {
			            console.log(res);
			            /* 새로생성 icon table로 수정한 부분 */
			            const tableRow = document.createElement("tr");
			            tableRow.id = res.iconNo;
			
			            const tableDataImage = document.createElement("td");
			            const img = document.createElement("img");
			            img.src = URL.createObjectURL(imageFile);
			            img.alt = comment;
			            img.style.cursor = "pointer";
			            img.style.width = "40px";
			            img.style.height = "40px";
			            img.style.marginLeft = "7px";
			            img.classList.add("icon-image")
			            tableDataImage.appendChild(img);
			            tableRow.appendChild(tableDataImage);
			
			            const tableDataComment = document.createElement("td");
			            tableDataComment.style.color = "rgb(251, 237, 219)";
			            tableDataComment.style.fontSize = "15px";
			            tableDataComment.className = "icon-comment";
			            console.log(tableDataComment);
			            tableDataComment.textContent = comment;
			            tableRow.appendChild(tableDataComment);
			
			            const tableDataDelete = document.createElement("td");
			            const deleteButton = document.createElement("a");
			            deleteButton.textContent = "X";
			            deleteButton.style.cursor = "pointer";
			            deleteButton.onclick = function() {
			                fn_del_icon(res.iconNo);
			            };
			            tableDataDelete.appendChild(deleteButton);
			            tableRow.appendChild(tableDataDelete);
			
			            iconBody.appendChild(tableRow);
			            // 입력 필드 초기화
			            imageUploadInput.value = "";
			            commentInput.value = "";
			        },
			        error: function (e) {
			            console.log(e);
			        }
			    });
			}

        

        /* 아이콘(이미지+코멘트) del_yn 업데이트 함수 */
        function fn_del_icon(p_no) {
            if (confirm("정말로 삭제 하시겠습니까?")) {
                $.ajax({
                    url: '<c:url value="/delIconDo" />'
                    , type: 'POST'
                    , data: JSON.stringify({ "iconNo": p_no })
                    , contentType: 'application/json'
                    , dataType: 'text'
                    , success: function (res) {
                        if (res == 'success') {
                            $("#" + p_no).remove();
                            console.log(res);
                        }
                    }, error: function (e) {
                        console.log(e)
                    }
                });
            }
        }
        /* cld(아이콘기록) del_yn 업데이트 함수 */
        function fn_del_cld(p_no) {
            if (confirm("정말로 삭제 하시겠습니까?")) {
                $.ajax({
                    url: '<c:url value="/delCldDo" />'
                    , type: 'POST'
                    , data: JSON.stringify({ "cldNo": p_no })
                    , contentType: 'application/json'
                    , dataType: 'text'
                    , success: function (res) {
                        if (res == 'success') {
                            $("#" + p_no).remove();
                            console.log(res);
                        }
                    }, error: function (e) {
                        console.log(e)
                    }
                });
            }
        } 
    </script>

</body>

</html>