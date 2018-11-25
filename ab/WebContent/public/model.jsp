<%@page import="bean.Topic"%>
<%@page import="dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*,java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理后台</title>
<link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>

		<jsp:include page="/public/head.jsp"></jsp:include>
		<jsp:include page="/public/menu.jsp"></jsp:include>
		<div id="opt_area">
			
			<!-- 主要操作写这里 -->

		</div>
		<jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>
