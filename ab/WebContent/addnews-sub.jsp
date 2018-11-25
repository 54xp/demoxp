<%@page import="dao.DBHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ntid = request.getParameter("ntid");
	String ntitle = request.getParameter("ntitle");
	String nauthor = request.getParameter("nauthor");
	String nsummary = request.getParameter("nsummary");
	String ncontent = request.getParameter("ncontent");
	String file = request.getParameter("file");
	
	String sql = "insert into news(ntid,ntitle,nauthor,nsummary,ncontent,file) values(?,?,?,?,?,?)";
	List<Object> list = new ArrayList<Object>();
	
	list.add(ntid);
	list.add(ntitle);
	list.add(nauthor);
	list.add(nsummary);
	list.add(ncontent);
	list.add(file);
	
	
	int i = new DBHelper().update(sql, list);
	if(i>0){ //新增成功
		response.sendRedirect("jsp03_addNews.jsp");
	}
%>