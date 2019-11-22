<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="guest.GuestDTO" %>
<%@ page import="utility.Utility" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="dao" class="guest.GuestDAO"/>

<%
	String root = request.getContextPath();
	request.setCharacterEncoding("utf-8");
	
	List<GuestDTO> list = null;
	Iterator<GuestDTO> iter = null;
	
	boolean flag = false;
	
%>