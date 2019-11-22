<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="notice.NoticeDTO" %>
<%@ page import="utility.Utility" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="dao" class="notice.NoticeDAO"/>

<%
	String root = request.getContextPath();
	request.setCharacterEncoding("utf-8");
	
	List<NoticeDTO> list = null;
	Iterator<NoticeDTO> iter = null;
	
	boolean flag = false;
	
%>