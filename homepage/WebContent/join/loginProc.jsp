<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/mssi.jsp" %>
<%
	String id = request.getParameter("id");//form.jsp의 name값을 받음
	String pw = request.getParameter("passwd");
	
	Map map = new HashMap();
	map.put("id", id);
	map.put("pw", pw);//dao에서 pw로 받았기 때문에..
	
	flag =dao.loginCheck(map);//t or f
	
	if(flag){
		String grade = dao.getGrade(id);
		session.setAttribute("id", id);
		session.setAttribute("grade", grade);
		
		
		  // ---------------------------------------------- 
	      // Cookie 저장, Checkbox는 선택하지 않으면 null 임 
	      // ---------------------------------------------- 
	      Cookie cookie = null;
		  
		  String c_id = request.getParameter("c_id");//Y, 아이디 저장 여부
		  
		  if(c_id !=null){
			  cookie = new Cookie("c_id", "Y");
			  cookie.setMaxAge(120);
			  response.addCookie(cookie);
			  
			  cookie = new Cookie("c_id_val", id);
			  cookie.setMaxAge(120);
			  response.addCookie(cookie);
			  
			  cookie = new Cookie("c_passwd_val", pw);
			  cookie.setMaxAge(120);
			  response.addCookie(cookie);
		  }else{
			  cookie = new Cookie("c_id", "");//쿠키삭제
			  cookie.setMaxAge(0);
			  response.addCookie(cookie);
			  
			  cookie = new Cookie("c_id_val", "");
			  cookie.setMaxAge(0);
			  response.addCookie(cookie);
			  
			  cookie = new Cookie("c_passwd_val", "");
			  cookie.setMaxAge(0);
			  response.addCookie(cookie);
		  }
		//-------------------------------------------------------
	}

%>


<!DOCTYPE html>

<html>
<head>
  <title>로그인처리</title>
    <meta charset="utf-8">
  
</head>
<body>
<jsp:include page="/menu/top.jsp"/>
 
<div class="container">
  <h1 class="col-sm-offset-2 col-sm-10">로그인처리</h1>
  <div class="well well-lg">
  <%
  if(flag){
	  out.print("로그인에 성공했습니다.");
  }else{
	  out.print("아이디 또는 비밀번호가 잘못 입력하셨거나<br>");
	  out.print("회원이 아닙니다. 회원가입을 하세요.");
  }

  %>
  </div>
	<button class="btn btn-default" onclick="location.href='../index.jsp'">홈</button>
	<button class="btn btn-default" onclick="history.back()">다시시도</button>
		

</div>
</body>
</html>



