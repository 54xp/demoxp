<%@page import="dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
<body>
<jsp:include page="/public/head.jsp"></jsp:include>
<jsp:include page="/public/menu.jsp"></jsp:include>
<h1 id="opt_type">删除：</h1>
<%
	String id = request.getParameter("topicId");
	String sql = "delete from title where id ='"+id+"'";
	int i = new DBHelper().update(sql, null);
	String message = i>0?"操作成功":"操作失败";
//	out.print("<script type=\"text/javascript\">alert('"+message+"')</script>");
	response.sendRedirect("topic-list.jsp");
%>
</body>
</html>