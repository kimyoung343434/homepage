<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/ssin.jsp" %>
<%

String id = (String)session.getAttribute("id");
String grade = (String)session.getAttribute("grade");
	
	int no = Integer.parseInt(request.getParameter("no"));
	dao.upViewcnt(no);
	NoticeDTO dto = dao.read(no);
	String content = dto.getContent().replaceAll("\r\n", "<br>");
	
%>


<!DOCTYPE html>

<html>
<head>
  <title>bbs</title>
  <meta charset="utf-8">
  <script type="text/javascript">
  function listb(){
	  var ur1 = "list.jsp";
	  ur1 = ur1 +"?col=<%=request.getParameter("col")%>";
	  ur1 = ur1 +"&word=<%=request.getParameter("word")%>";
	  ur1 = ur1 + "&nowPage=<%=request.getParameter("nowPage")%>";

	  
	  location.href=ur1;
  }
  	function updateb(no){
  		var ur1 = "updateForm.jsp";
  		ur1 = ur1 + "?no="+no;
  	  ur1 = ur1 +"&col=<%=request.getParameter("col")%>";
	  ur1 = ur1 +"&word=<%=request.getParameter("word")%>";
	  ur1 = ur1 + "&nowPage=<%=request.getParameter("nowPage")%>";

  		
  		location.href=ur1;
  		
  		
  	}
  	
	function replyb(no){
  		var ur1 = "replyForm.jsp";
  		ur1 = ur1 + "?no="+no;
  	  ur1 = ur1 +"&col=<%=request.getParameter("col")%>";
	  ur1 = ur1 +"&word=<%=request.getParameter("word")%>";
	  ur1 = ur1 + "&nowPage=<%=request.getParameter("nowPage")%>";

  		
  		location.href=ur1;
  		
  		
  	}
  	
	function delb(no){
  		var ur1 = "deleteForm.jsp";
  		ur1 = ur1 + "?no="+no;
  	  ur1 = ur1 +"&col=<%=request.getParameter("col")%>";
	  ur1 = ur1 +"&word=<%=request.getParameter("word")%>";
	  ur1 = ur1 + "&nowPage=<%=request.getParameter("nowPage")%>";

  		
  		location.href=ur1;
  		
  		
  	}
  
  
  </script>
  
</head>
<body>
<jsp:include page="/menu/top.jsp"/>
 
<div class="container">

  <h1>조회</h1>
	<div class="panel panel-default">
	  <div class="panel-heading">작성자</div>
	  <div class="panel-body"><%=dto.getId() %></div>
	  
	   <div class="panel-heading">제목</div>
	  <div class="panel-body"><%=dto.getTitle() %></div>
	  
	   <div class="panel-heading">내용</div>
	  <div class="panel-body"  style="height: 200px"><%=dto.getContent() %></div>
	  
	   <div class="panel-heading">조회수</div>
	  <div class="panel-body"><%=dto.getViewcnt() %></div>
	  
	  
	  <div class="panel-heading">등록일</div>
	  <div class="panel-body"><%=dto.getWdate() %></div>
</div>

<%if(id!=null && grade.equals("A")) {%>
<button class="btn btn-default" onclick="location.href='./createForm.jsp'">등록</button>
<button class="btn btn-default" onclick="updateb('<%=no%>')">수정</button>
<button class="btn btn-default" onclick="delb('<%=no%>')">삭제</button>
<%} %>
<button class="btn btn-default" onclick="listb()">목록</button>



</div>
</body>
</html>




