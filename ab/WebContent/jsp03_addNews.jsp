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

	<div id="main">
		<jsp:include page="/public/menu.jsp"></jsp:include>
		<div id="opt_area">
			<h1 id="opt_type">添加新闻：</h1>
			<form action="addtopic.jsp" method="post">
				<p>
					<label> 主题 </label> <select name="ntid">
						<option value="-1">选择</option>
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
	</div>

<jsp:include page="/public/foot.jsp"></jsp:include>


</body>
</html>
