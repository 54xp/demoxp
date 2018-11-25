<%@page import="dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("newsId");
	String sql = "delete  from news where id='"+id+"'";
	int i = new DBHelper().update(sql, null);
	String message = i>0?"操作成功":"操作失败";
	response.sendRedirect("news-list.jsp");
%>