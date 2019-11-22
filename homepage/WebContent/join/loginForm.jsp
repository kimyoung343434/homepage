<%@ page contentType="text/html; charset=UTF-8" %> 
<%
/*----쿠키설정 내용시작----------------------------*/

String c_id = "";//id저장 여부를 저장하는 변수, Y
String c_id_val="";//id 값
String c_passwd_val="";//비밀번호 값

Cookie[] cookies = request.getCookies();
Cookie cookie = null;

if(cookies !=null){
	for(int i=0; i<cookies.length;i++){
		cookie = cookies[i];
		
		if(cookie.getName().equals("c_id")){
			c_id = cookie.getValue();//Y
		}else if(cookie.getName().equals("c_id_val")){
			c_id_val = cookie.getValue();//사용자의 아이디
		}else if(cookie.getName().equals("c_passwd_val")){
			c_passwd_val = cookie.getValue();//사용자의 비밀번호
		}
		
	}
}



%>


<!DOCTYPE html>

<html>
<head>
  <title>로그인처리</title>
    <meta charset="utf-8">
    <script type="text/javascript">
    function idFind(){
    	 var url = "findId_Form.jsp";
   	  
    	 var wr = window.open(url, "id중복확인"	, "width=500, height=350");
 		wr.moveTo((window.screen.width-500)/2, (window.screen.height-350)/2);
    }
    
    function passwdFind(){
    	 var url = "findPasswd_Form.jsp";
   	  
    	  var wr = window.open(url, "id중복확인"	, "width=500, height=350");
  		wr.moveTo((window.screen.width-500)/2, (window.screen.height-350)/2);
    }
    
    </script>
    <style type="text/css">
    #idfind, #passwdfind{
    	color : red;
    }
    </style>
  
</head>
<body>
<jsp:include page="/menu/top.jsp"/>
 
<div class="container">
  <h1 class="col-sm-offset-2 col-sm-10">로그인</h1>
	  <form class="form-horizontal" 
	  action="<%=request.getContextPath() %>/join/loginProc.jsp"
	  method="post"
	  name='frm'
	  >
	
	
	
	    <div class="form-group">
		<label class="control-label col-sm-2" for="id">아이디:</label>
		<div class="col-sm-4">
		<input type="text" class="form-control"  id="id" 
		placeholder="Enter id" name="id"  required="required"
		value='<%=c_id_val %>'>
		</div>
		</div>
		
		
		<div class="form-group">
		<label class="control-label col-sm-2" for="pwd">비밀번호:</label>
		<div class="col-sm-4">
		<input type="password" class="form-control" id="pwd" 
		placeholder="Enter password" name="passwd" required="required"
		value='<%=c_passwd_val %>'>
		</div>
		</div>
		
		
		 <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-6">
        <div class="checkbox">
          <label>
          <%if(c_id.equals("Y")){ %>
          <input type="checkbox" name="c_id" value="Y" checked="checked"> Remember ID
          <%}else{ %>
          <input type="checkbox" name="c_id" value="Y"> Remember ID
          <%} %>
          </label>
        </div>
		</div>
		</div>
		
		<div class="form-group">        
		<div class="col-sm-offset-2 col-sm-8">
		<button type="submit" class="btn btn-default">로그인</button>
		<button type="submit" class="btn btn-default"
		onclick="location.href='agreement.jsp'">회원가입</button>
		
		
		<button type="submit" class="btn btn-default"
		onclick="idFind()">아이디찾기</button>
		<div id="idfind"></div>
		<button type="submit" class="btn btn-default"
		onclick="passwdFind()">패스워드 찾기</button>
		<div id="passwdfind"></div>
		
		</div>
		</div>
		</form>
		

</div>
</body>
</html>