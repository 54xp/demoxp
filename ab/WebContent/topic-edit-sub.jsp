<%@page import="dao.DBHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//获取请求参数
	String ntitle = request.getParameter("ntitle");
	String nauthor = request.getParameter("nauthor");
	String nsummary = request.getParameter("nsummary");
	String id = request.getParameter("id");
	//连接数据库进行操作
	String sql = "update title set ntitle=?,nauthor=?,nsummary=? where id =?";
	List<Object> list = new ArrayList<Object>();
	list.add(ntitle);
	list.add(nauthor);
	list.add(nsummary);
	list.add(id);
	
	int i = new DBHelper().update(sql, list);
	if(i>0){ //新增成功
		response.sendRedirect("jsp03_addNews.jsp");
	}
%>