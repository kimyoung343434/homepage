<%@ page contentType="text/html; charset=UTF-8" %> 



<!DOCTYPE html>

<html>
<head>
  <title>비밀번호 찾기</title>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="ajaxError.js"></script>
  <script type="text/javascript" src="jquery.js"></script>
  <script type="text/javascript">
  
  function passwdfind(){
	var url = "findPasswd_Proc.jsp";
	param = "id=" + document.frm.id.value;
	param +="&mname=" + document.frm.mname.value;
	
	$.get(url, param, function(data, textStatus){
		$("#passwdfind").text(" ");
		$("#passwdfind").append(data);
	})
  }
  
  </script>
</head>
<body>

 
<div class="container">
  <h1 class="col-sm-offset-2 col-sm-10">비번찾기</h1>
	  <form class="form-horizontal" 
	  action="findPasswd_Proc.jsp"
	  method="post"
	  name="frm">
	
	
	
	    <div class="form-group">
		<label class="control-label col-sm-2" for="id">아이디:</label>
		<div class="col-sm-6">
		<input type="text" class="form-control" id="id" placeholder="Enter id" 
		name="id"  value="admin">
		</div>
		</div>
		
		
		 <div class="form-group">
		<label class="control-label col-sm-2" for="mname">이름:</label>
		<div class="col-sm-4">
		<input type="text" class="form-control" id="mname" 
		placeholder="Enter 이름" name="mname"  value="김근영">
		</div>
		</div>
		
		
		
		<div class="form-group">        
		<div class="col-sm-offset-2 col-sm-5">
		<button type="button" class="btn btn-default" onclick="passwdfind()">찾기</button>
		<button type="reset" class="btn btn-default">취소</button>
		</div>
		<div id="passwdfind"></div>
		</div>
		</form>
		

</div>
</body>
</html>