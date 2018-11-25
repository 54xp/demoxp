<%@page import="bean.Topic"%>
<%@page import="dao.DBHelper"%>
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
 
	<div id="opt_area">
			<h1 id="opt_type">添加新闻：</h1>
			<!-- 
				用commons-io-2.0.jar commons-fileupload-1.2.1.jar 添加 enctype="multipart/form-data"
				不用就是<form action="addnews-subjar.jsp" method="post" >
			 -->
			 <!--  entype 默认值是application/x-www-form-urlencoded 提交表单数据，默认的形式是a=xx&b=xxx
			 	   multipart/form-data 将表单数据作为二进制的流进行传输
			  -->
			<form action="addnews-subjar.jsp" method="post" enctype="multipart/form-data">
				<p>
					<label> 主题 </label> <select name="ntid">
						<option value="-1">选择</option>
						<%
							String sql = "select * from title";
							List<Topic> list = new DBHelper().find(sql,Topic.class,null);
						for(int i=0;i<list.size();i++){
								out.print("<option value='"+list.get(i).getId()+"'>"+list.get(i).getNtitle()+"</option>");
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
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" cols="70" rows="10"></textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input name="file" type="file" class="opt_input" />
				</p>
				<input name="action" type="hidden" value="addnews"> <input
					type="submit" value="提交" class="opt_sub" /> 
					<input type="reset" value="重置" class="opt_sub" />
			</form>

		</div>
</body>
</html>