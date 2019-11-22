<%@ page contentType="text/html; charset=UTF-8" %> 



<!DOCTYPE html>

<html>
<head>
  <title>id찾기</title>
    <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="ajaxError.js"></script>
  <script type="text/javascript" src="jquery.js"></script>
  <script type="text/javascript">

 function idfind(){
	 var url = "findId_Proc.jsp";
	 param = "mname=" + document.frm.mname.value;
	 param +="&tel=" + document.frm.tel.value;
	 
	 $.get(url, param, function(data, textStatus){
		$("#idfind").text(" ");
		 $("#idfind").append(data);
	 })
 }
 
  
  </script>
</head>
<body>

 
<div class="container">
  <h1 class="col-sm-offset-2 col-sm-10">id찾기</h1>
	  <form class="form-horizontal"  action="findId_Proc.jsp" method="post" name="frm">
	
	
	
	    <div class="form-group">
		<label class="control-label col-sm-2" for="mname">이름:</label>
		<div class="col-sm-4">
		<input type="text" class="form-control" id="mname" 
		placeholder="Enter 이름"  name="mname"  value="김근영">
		</div>
		</div>
		
		 <div class="form-group">
		<label class="control-label col-sm-2" for="tel">전화번호:</label>
		<div class="col-sm-4">
		<input type="text" class="form-control" id="tel" 
		 placeholder="Enter 전화번호" name="tel" value="444-4444">
		</div>
		</div>
		
		
		
		<div class="form-group">        
		<div class="col-sm-offset-2 col-sm-5">
		<button type="button" class="btn btn-default" onclick="idfind()">찾기</button>
		<button type="reset" class="btn btn-default">취소</button>
		</div>
		<div id="idfind"></div>
		</div>
		</form>
		

</div>
</body>
</html>