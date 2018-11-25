<%@page import="dao.User"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.awt.image.DataBufferUShort"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	String sql = "select * from table_1 where name =? and pwd=?";
	List<Object> list = new ArrayList<Object>();
	list.add(name);
	list.add(pwd);
	List<User> list2 = new DBHelper().find(sql, User.class, list);
	
	if(list2.size()==1){
		session.setAttribute("admin", "123");
		request.getRequestDispatcher("jsp013.jsp").forward(request,response);
	}else{
		response.sendRedirect("jsp01.jsp");
	}
%>