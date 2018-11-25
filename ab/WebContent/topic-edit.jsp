<%@page import="bean.Topic"%>
<%@page import="dao.DBHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 id="opt_type">修改主题：</h1>
<%
	String id = request.getParameter("topicId");
	String sql = "select * from title where id = '"+id+"' ";
	Topic topic = new DBHelper().findByOne(sql, Topic.class, null);
%>
			<form action="topic-edit-sub.jsp" method="post">
				<input type="hidden" name="id" id ="id" value="<%=topic.getId()%>">
				<p>
					<label> 标题 </label> 
					<input name="ntitle" type="text" class="opt_input" value="<%=topic.getNtitle() %>" />
				</p>
				<p>
					<label> 作者 </label>
					 <input name="nauthor" type="text" class="opt_input" value="<%=topic.getNauthor() %>"/>
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3"><%=topic.getNsummary() %></textarea>
				</p>
			 
				<input	type="submit" value="提交" class="opt_sub" />
				 <input type="reset" value="重置" class="opt_sub" />
			</form>

</body>
</html>