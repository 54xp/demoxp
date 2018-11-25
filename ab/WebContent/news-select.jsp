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
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>
<%!		//获得页面搜索框输入的值
	String searchTop = "";	
%>
<h1>新闻列表</h1>
 	<jsp:include page="/public/head.jsp"></jsp:include>
 	<jsp:include page="/public/menu.jsp"></jsp:include>
 	<form action="news-select.jsp" method="get">
 		主题<input type="text" name="searchTop">
	 	<input type="submit" name="搜索" value="搜索">
 	</form>
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
 	// 查询条件参数
 	searchTop = "";
 	if(request.getParameter("searchTop") !=null && "".equals(request.getParameter("searchTop"))){
 		searchTop = request.getParameter("searchTop");
 	}
 	int totalSize=0; 	
 	int perpageSize=0;
 	int totalPage=0;
 	int nowPage=0;
 	int start=0;
 	int end=0;
 	int beforePage=0;
 	int afterPage=0;
 	String sql2="select count(1) from news";
 	
 	// 拼装带条件查询的sql
 	boolean flag = false;
 	if(!"".equals(searchTop) && searchTop !=null && searchTop.trim().length()>0){ // 有输入条件
 		sql2 = sql2+" where ntitle like '%"+searchTop+"' ";
 		flag =true;
 		System.out.println("查询语句为:"+sql2);
 	}
 	List<String> list2 = new DBHelper().findList(sql2, null);
 	totalSize = Integer.parseInt(list2.get(0));
 	perpageSize=5;
 	//总页数
 	if(totalSize % perpageSize == 0){
 		totalPage = totalSize/perpageSize;
 	}else{
 		totalPage = totalSize/perpageSize+1;
 	}
 	// 当前页
 	if(request.getParameter("nowPage")==null || "".equals(request.getParameter("nowPage"))){
 		nowPage=1;
 	}else{
 		nowPage=Integer.parseInt(request.getParameter("nowPage"));
 	}
 	if(nowPage==1){
 		beforePage=1;
 	}else{
 		beforePage=nowPage-1;
 	}
 	if(nowPage==totalPage){
 		afterPage=nowPage;
 	}else{
 		afterPage=nowPage+1;
 	}
 	start =(nowPage-1)*perpageSize;	 //查询位置的起始页
 	end=perpageSize;				 //  在sql语句里限制每页输出多少条
 
 	String sql = "select m.* from"+ 
 	"(select n.*,t.ntitle as tname from news n left join title t on n.ntid=t.id) m limit "+start+","+end;
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
 <div>
 	<span><a href="news-select.jsp?nowPage=1&searchTop<%=searchTop %>">首页</a></span>
 	<span><a href="news-select.jsp?nowPage=<%=beforePage%>&searchTop<%=searchTop %>">上一页</a></span>
 	<span><a href="news-select.jsp?nowPage=<%=afterPage%>&searchTop<%=searchTop %>">下一页</a></span>
 	<span><a href="news-select.jsp?nowPage=<%=totalPage%>&searchTop<%=searchTop %>">尾页</a></span>
 </div>
 <jsp:include page="/public/foot.jsp"></jsp:include>
</body>
</html>