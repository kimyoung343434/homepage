<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="join.JoinDAO" />

<%

String tel = request.getParameter("tel");

boolean flag = dao.duplicatedTel(tel);

String str = "";

if(flag){
	str = tel + "는 중복되어서 사용할 수 없습니다.";
}else{
	str = tel + "는 중복아님, 사용가능 합니다.";
}

out.print(str);

%>