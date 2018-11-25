<%@page import="dao.DBHelper"%>
<%@page import="bean.Topic"%>
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
<%
 		request.setCharacterEncoding("utf-8");
 		response.setCharacterEncoding("utf-8");
 	%>
 	<%!	//获得页面搜索框输入的值
 		String searchTop="";
 	%>
 <h1>主题列表</h1>
 <jsp:include page="/public/head.jsp"></jsp:include>
 <jsp:include page="/public/menu.jsp"></jsp:include>
	 <form action="topic-list3.jsp" method="get">
	 	主题<input type="text" name="searchTop">
	 	<input type="submit" name="搜索" value="搜索">
	 </form>
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
 	searchTop="";
 	if(request.getParameter("searchTop") != null && !"".equals(request.getParameter("searchTop"))){
 		searchTop=request.getParameter("searchTop");
 	
 	//	byte source[]= searchTop.getBytes("iso8859-1");
 	//	searchTop = new String(source,"utf-8");
 	}
 	int totalSize=0;	//总记录数
 	int perpageSize=0;	// 每页显示多少条
 	int totalPage=0; 	// 总页数
 	int nowPage=0;      //当前页
 	int start=0;  		//查询位置的起始页
 	int end=0;			// 在sql语句里限制每页输出多少条
 	int beforePage=0; 	// 上一页
 	int afterPage=0;	//	下一页
 	String sql2 = "select count(1) from title";
 	
 	boolean flag =false;
 	if(!"".equals(searchTop) && searchTop!=null && searchTop.trim().length()>0){ // 有输入条件
 		sql2 = sql2+" where ntitle like '%"+searchTop+"%'";
 		flag = true;
 		System.out.println("查询语句是："+sql2);
 	}
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
 	String sql = "";
 	if(flag){
 		 sql = "select * from title where ntitle like '%"+searchTop+"%' limit "+start+","+end;
 	}else{
 		 sql = "select * from title limit "+start+","+end;
 	}
 	
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
 	<span><a href="topic-list3.jsp?nowPage=1&searchTop<%=searchTop %>">首页</a></span>
 	<span><a href="topic-list3.jsp?nowPage=<%=beforePage %>&searchTop<%=searchTop %>">上一页</a></span>
 	<span><a href="topic-list3.jsp?nowPage=<%=afterPage %>&searchTop<%=searchTop %>">下一页</a></span>
 	<span><a href="topic-list3.jsp?nowPage=<%=totalPage %>&searchTop<%=searchTop %>">尾页</a></span>
 </div>
 <jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>