
<%@page import="dao.DBHelper"%>
<%@page import="bean.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/public/cksLogin.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>新闻列表</h1>
 <jsp:include page="/public/head.jsp"></jsp:include>

 	<jsp:include page="/public/menu.jsp"></jsp:include>
 
 	<table border="1"  >
 	<tr>
 		<td>id</td>
 		<td>主题id</td>
 		<td>主题名称</td>
 		<td>标题名字</td>
 		<td>作者</td>
 		<td>摘要</td>
 		<td>内容</td>
 		<td>文件</td>
 		<td>操作</td>
 		<td>删除</td>
 	</tr>
 <%
 	String sql = "select m.* from"+ 
 	"(select n.*,t.ntitle as tname from news n left join title t on n.ntid=t.id) m";
 	List<News> list = new DBHelper().find(sql, News.class, null);
 	for(int i =0;i<list.size();i++){
 		out.print("<tr>");
 		out.print("<td>"+list.get(i).getId()+"</td>");
 		out.print("<td>"+list.get(i).getNtid()+"</td>");
 		out.print("<td>"+list.get(i).getNtitle()+"</td>");
 		out.print("<td>"+list.get(i).getTname()+"</td>");
 		out.print("<td>"+list.get(i).getNauthor()+"</td>");
 		out.print("<td>"+list.get(i).getNsummary()+"</td>");
 		out.print("<td>"+list.get(i).getNcontent()+"</td>");
 		out.print("<td>"+list.get(i).getFile()+"</td>");
 		out.print("<td><a href='News-edit.jsp?newsId="+list.get(i).getId()+"'>修改</a></td>");
 		out.print("<td><a href='News-delete.jsp?newsId="+list.get(i).getId()+"'>删除</a></td>");
 		out.print("</tr>");
 	}
 %>
 
 </table>
 
 <jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>