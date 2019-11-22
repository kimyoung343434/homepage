<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="/ssi/bssi.jsp" %>
<jsp:useBean id="dto" class="guest.GuestDTO"/>
<jsp:setProperty property="*" name="dto" />
<%
	Map map = new HashMap();
	map.put("guestno", dto.getGuestno());
	map.put("passwd",dto.getPasswd());

	boolean pflag = dao.passCheck(map);
	flag = false;
	
	if(pflag){
		flag = dao.update(dto);
	}


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
  		if(!pflag){
  			out.print("잘못된 비밀번호 입니다.");
  		}else if(flag){
  			out.print("글 수정을 성공했습니다.");
  		}else{
  			out.print("글 수정을 실패했습니다.");
  		}
  %>
  </div>
  <%
  		if(!pflag){
  %>
		<button class="btn btn-default" onclick="history.back()">다시시도</button>
<% }%>

	<button class="btn btn-default" onclick="location.href='createForm.jsp'">다시등록</button>
	<button class="btn btn-default" onclick="listb()">목록</button>
</div>
</body>
</html>





