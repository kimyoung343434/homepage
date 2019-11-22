<%@ page contentType="text/html; charset=UTF-8" %> 



<!DOCTYPE html>

<html>
<head>
  <title>전화번호 중복확인</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <style type="text/css">
  #red{
  color : red;
  }
  </style>
  
</head>
<body>

 
<div class="container">
  <h1 class="col-sm-offset-2 col-sm-10">tel 중복확인</h1>
	  <form class="form-horizontal" 
	  action="tel_proc.jsp"
	  method="post">
	
	<p id="red" class="col-sm-offset-2 col-sm-10">전화번호를 입력하세요</p>
	
	    <div class="form-group">
		<label class="control-label col-sm-2" for="tel">전화번호:</label>
		<div class="col-sm-6">
		<input type="text" class="form-control" id="tel" placeholder="Enter 전화번호" 
		name="tel" required="required">
		</div>
		</div>
		
		
		
		<div class="form-group">        
		<div class="col-sm-offset-2 col-sm-8">
		<button class="btn btn-default">중복확인</button>
		<button type="reset" class="btn btn-default">취소</button>
		</div>
		</div>
		</form>
		

</div>
</body>
</html>