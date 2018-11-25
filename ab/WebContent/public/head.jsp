<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 头部文件 -->
    <div id="header">
		<div id="welcome">欢迎使用新闻管理系统！</div>
		<div id="nav">
			<div id="logo">
				<img src="Images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="Images/a_b01.gif" alt="" />
			</div>
		</div>
	</div>

	<div id="admin_bar">
		<div id="status">
			管理员： <%=session.getAttribute("username")%>登录 &#160;&#160;&#160;&#160; <a href="loginOut.jsp">退出</a>
		</div>
		<div id="channel"></div>
	</div>