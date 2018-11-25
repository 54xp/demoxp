<%@page import="dao.DBHelper"%>
<%@page import="bean.Topic"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>主题列表</h1>
 <jsp:include page="/public/head.jsp"></jsp:include>
 <jsp:include page="/public/menu.jsp"></jsp:include>
 <table border="1"   csllapacing="0"  >
 	<tr>
 		<td>id</td>
 		<td>主题名称</td>
 		<td>作者</td>
 		<td>描述</td>
 		<td>操作</td>
 		<td>删除</td>
 	</tr>
 <%
 	String sql = "select * from title";
 	List<Topic> list = new DBHelper().find(sql, Topic.class, null);
 	for(int i =0;i<list.size();i++){
 		out.print("<tr>");
 		out.print("<td>"+list.get(i).getId()+"</td>");
 		out.print("<td>"+list.get(i).getNtitle()+"</td>");
 		out.print("<td>"+list.get(i).getNauthor()+"</td>");
 		out.print("<td>"+list.get(i).getNsummary()+"</td>");
 		out.print("<td><a href='topic-edit.jsp?topicId="+list.get(i).getId()+"'>修改</a></td>");
 		out.print("<td><a href='topic-delete.jsp?topicId="+list.get(i).getId()+"'>删除</a></td>");
 		out.print("</tr>");
 	}
 %>
 </table>

 <jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>