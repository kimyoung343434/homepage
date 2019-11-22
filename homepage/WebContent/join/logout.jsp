<%@ page contentType="text/html; charset=UTF-8" %> 
<%
session.invalidate();//모두 지운다
//session.removeAttribute("id");//id속성만 지운다.

response.sendRedirect("../index.jsp");




%>