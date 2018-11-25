<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = (String)session.getAttribute("username");
	if(username == null || "".equals(username)){  //没有登录
		response.sendRedirect("jsp03_newsIndex.jsp");	
	}
%>