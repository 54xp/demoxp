<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("username");
	response.sendRedirect("jsp03_newsIndex.jsp");
%>