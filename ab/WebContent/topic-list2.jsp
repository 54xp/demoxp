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
 	int totalSize=0;	//总记录数
 	int perpageSize=0;	// 每页显示多少条
 	int totalPage=0; 	// 总页数
 	int nowPage=0;      //当前页
 	int start=0;  		//查询位置的起始页
 	int end=0;			//结束页
 	int beforePage=0; 	//
 	int afterPage=0;
 	String sql2 = "select count(1) from title";
 	List<String> list2 = new DBHelper().findList(sql2, null);
 	// 总记录数
 	totalSize = Integer.parseInt(list2.get(0));
 	//每页显示多少条
 	perpageSize=3;
 	//总页数
 	if(totalSize % perpageSize == 0){
 		totalPage =totalSize / perpageSize;
 	}else{
 		totalPage =totalSize / perpageSize+1;
 	}
 	// 当前页
 	if(request.getParameter("nowPage")==null || "".equals(request.getParameter("nowPage"))){
 		nowPage =1;
 	}else{
 		nowPage=Integer.parseInt(request.getParameter("nowPage"));
 	}
 	if(nowPage==1){
 		beforePage=1;
 	}else{
 		beforePage=nowPage-1;
 	}
 	if(nowPage==totalPage){
 		afterPage=totalPage;
 	}else{
 		afterPage=nowPage+1;
 	}
 	start =(nowPage-1)*perpageSize;
 	end=perpageSize;
 	
 	String sql = "select * from title limit "+start+","+end;
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
 <div>
 	<span><a href="topic-list2.jsp?nowPage=1">首页</a></span>
 	<span><a href="topic-list2.jsp?nowPage=<%=beforePage %>">上一页</a></span>
 	<span><a href="topic-list2.jsp?nowPage=<%=afterPage %>">下一页</a></span>
 	<span><a href="topic-list2.jsp?nowPage=<%=totalPage %>">尾页</a></span>
 </div>
 <jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>