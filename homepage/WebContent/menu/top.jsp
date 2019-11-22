<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% request.setCharacterEncoding("utf-8"); 
	
// 	절대경로
	String root = request.getContextPath();

	String id = (String)session.getAttribute("id");
	
	String grade = (String)session.getAttribute("grade");
	
	String str = "";
	
	if(id!=null && grade.equals("A")){
		str = "관리자 페이지 입니다.";
	}else if(id!=null && !grade.equals("A")){
		str = "안녕하세요" + id + "님!";
	}
	
%>
    
    
   


<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<%=root %>/js/ajaxError.js"></script>

<style type="text/css">
#grade{

	color : orange;
}



* {box-sizing:border-box}

/* Slideshow container */
.slideshow-container {
  max-width: 300px;
  position: relative;
  margin: auto;
}

/* Hide the images by default */
.mySlides {
  display: none;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
/* .prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
} */

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active, .dot:hover {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s; 
}

@-webkit-keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4}
  to {opacity: 1}
}

</style>

</head>
<body>




<%-- <div class="jumbotron">
		<img src="<%=root%>/menu/images/aaa.jpg"  class="img-responsive img-thumbnail" alt="CinqueTerre">
	<br>
  </div> --%>
  
  <!-- Slideshow container -->
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <!-- <div class="numbertext">1 / 3</div> -->
    <img src="<%=root%>/menu/images/111.jpg"  style="width:100%">
    <!-- <div class="text">Caption Text</div> -->
  </div>

  <div class="mySlides fade">
    <!-- <div class="numbertext">2 / 3</div> -->
    <img src="<%=root%>/menu/images/lights.jpg"  style="width:100%">
    <!-- <div class="text">Caption Two</div> -->
  </div>

  <div class="mySlides fade">
    <!-- <div class="numbertext">3 / 3</div> -->
    <img src="<%=root%>/menu/images/nature.jpg"  style="width:100%">
    <!-- <div class="text">Caption Three</div> -->
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>
<br>

<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>
  
	<p id="grade"><%=str %></p>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
	<li class="active"><a href="<%=root%>/index.jsp">Home</a></li>
      
     <%--  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <li><a href="<%=root%>/memo/list.jsp">메모 목록</a></li>
			<li><a href="<%=root%>/memo/createForm.jsp">메모생성</a></li>
          
        </ul>
      </li>
       --%>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">방명록 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<%=root %>/guest/list.jsp">게시판목록</a></li>	
		<li><a href="<%=root %>/guest/createForm.jsp">게시판생성</a></li>
          </ul>
          </li>
          
          
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">공지사항 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<%=root %>/notice/list.jsp">공지사항목록</a></li>	
          <%if(id!=null && grade.equals("A")){ %>
		<li><a href="<%=root %>/notice/createForm.jsp">공지사항등록</a></li>
		<%} %>
          </ul>
          </li>
          <%if(id==null) {%>
          <li><a href="<%=root%>/join/agreement.jsp">회원가입</a></li>
          <li><a href="<%=root %>/join/loginForm.jsp">로그인</a></li>
          <%}else{ %>
          <li><a href="<%=root%>/join/read.jsp">나의정보</a></li>
          <li><a href="<%=root %>/join/updateForm.jsp">회원수정</a></li>
          <li><a href="<%=root%>/join/logout.jsp">로그아웃</a></li>
         <%} %>
         
         <%if(id!=null && grade.equals("A")) {%>
         <li><a href="<%=root%>/admin/list.jsp">회원 목록</a></li>
         <%} %>
    </ul>
   
  </div>
</nav>
</body>
</html>



