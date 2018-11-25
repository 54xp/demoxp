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
<h1 id="opt_type">添加主题：</h1>
			<form action="news_manage.jsp" method="post">
				<p>
					<label> 主题 </label> 
					<select name="ntid">
							<option value="-1">选择</option>
						<%
							String sql = "select * from title";
							List<Topic> list = new DBHelper().find(sql, Topic.class, null);
							for(int i=0;i<list.size();i++){
								out.print("<option value='"+i+"'>"+list.get(i).getNtitle()+"</option>");
							}
						%>
					</select>
				</p>
				<p>
					<label> 标题 </label> <input name="ntitle" type="text" class="opt_input" />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" type="text" class="opt_input" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" cols="40" rows="3"></textarea>
				</p>
			
				<input name="action" type="hidden" value="addnews"> 
				<input	type="submit" value="提交" class="opt_sub" />
				 <input type="reset" value="重置" class="opt_sub" />
			</form>

</body>
</html>