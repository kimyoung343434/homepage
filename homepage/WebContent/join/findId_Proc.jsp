<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/mssi.jsp" %>
<%
	String tel = request.getParameter("tel");
	String mname = request.getParameter("mname");
	
	Map map = new HashMap();
	map.put("tel", tel);
	map.put("mname", mname);
	
	String id = dao.findID(map);

%>


<!DOCTYPE html>

<html>
<head>
  <title>회원</title>
    <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function use(){
	  opener.frm.id.value='<%=id%>';
	  self.close();
	  
  }
  
  </script>
</head>
<body>

 
<div class="container">
<%
if(id!=null){
	out.print("당신의 아이디는:" + id);
	out.print("<button class='btn btn-default' onclick='use()'>사용</button>");
}else{
	out.print("아이디가 없습니다.");
}


%>
  
</div>

<div class="col-sm-offset-2 col-sm-8">
	<button class="btn btn-default" onclick="location.href='findId_Form.jsp'">다시시도</button>
	<button class="btn btn-default" onclick="window.close()">닫기</button>

</div>
</body>
</html>




