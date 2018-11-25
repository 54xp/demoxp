<%@page import="bean.Topic"%>
<%@page import="java.util.List"%>
<%@page import="bean.News"%>
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
	<div id="main">
		<div id="opt_area">
			<h1 id="opt_type">新闻修改：</h1>
			<%
				String id = request.getParameter("newsId");
				String sql = "select * from news where id='"+id+"'";
				News news = new DBHelper().findByOne(sql, News.class, null);
			%>
			<form action="News-edit-sub.jsp" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="<%=news.getId() %>">
				<p>
					<label> 主题 </label> <select name="ntid">
						<option value="-1">选择</option>
						<%
							String sql2 = "select * from title";
							List<Topic> list = new DBHelper().find(sql2, Topic.class, null);
							for(int i=0;i<list.size();i++){
								if(news.getId() == list.get(i).getId()){
									out.print("<option value='"+i+"' selected>"+list.get(i).getNtitle()+"</option>");
								}else{
									out.print("<option value='"+i+"'>"+list.get(i).getNtitle()+"</option>");
								}
							}
						%>
					</select>
				</p>
				<p>
					<label> 标题 </label> <input name="ntitle" type="text" class="opt_input" value="<%=news.getNtitle() %>"  />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" type="text" class="opt_input" value="<%=news.getNauthor() %>"/>
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3" ><%=news.getNsummary() %></textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10"><%=news.getNcontent() %></textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="file" type="file" class="opt_input" value="<%=news.getFile() %>"/>
				</p>
				<input name="action" type="hidden" value="addnews"> <input
					type="submit" value="提交" class="opt_sub" /> 
					<input type="reset" value="重置" class="opt_sub" />
			</form>

		</div>
	</div>



</body>
</html>