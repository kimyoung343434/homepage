<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/bssi.jsp" %>
<jsp:useBean id="dto" class="guest.GuestDTO"/>
<jsp:setProperty property="*" name="dto" />
<%
	Map map = new HashMap();
	map.put("grpno", dto.getGrpno());
	map.put("ansnum",dto.getAnsnum());

	dao.reply_ansnum(map); //기존답변의 순서를 변경한다.
	
	
		flag = dao.reply_create(dto); //답변등록
	


%>

<!DOCTYPE html>

<html>
<head>
  <title>guest</title>
    <meta charset="utf-8">
    <script type="text/javascript">
    function listb(){
    	var ur1 = "list.jsp";
    	ur1 = ur1 + "?col=<%=request.getParameter("col")%>";
    	ur1 = ur1 + "&word=<%=request.getParameter("word")%>";
    	ur1 = ur1 + "&nowPage=<%=request.getParameter("nowPage")%>";

    	location.href=ur1;
    	
    }
    
    
    </script>
  
</head>
<body>
<jsp:include page="/menu/top.jsp"/>
 
<div class="container">
  
  <div class="well well-lg">
  <%
  		 if(flag){
  			out.print("글 답변을 성공했습니다.");
  		}else{
  			out.print("글 답변을 실패했습니다.");
  		}
  
  %>
  </div>
  

	<button class="btn btn-default" onclick="location.href='createForm.jsp'">다시등록</button>
	<button class="btn btn-default" onclick="listb()">목록</button>
</div>
</body>
</html>





