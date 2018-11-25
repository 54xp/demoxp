<%@page import="java.util.ArrayList"%>
<%@page import="dao.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	
	String sql = "select * from test where name=? and pwd=?";
	List<Object> list = new ArrayList<Object>();
	list.add(name);
	list.add(pwd);

	List<User> list2 = new DBHelper().find(sql,User.class,list);
	if(list2.size() ==1){
		session.setAttribute("admin", "123");
		request.getRequestDispatcher("jsp022.jsp").forward(request,response);
	}else{
		response.sendRedirect("jsp02.jsp");
	}
%>