<%@page import="dao.User"%>
<%@page import="dao.DBHelper"%>
<%@page import="bean.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("username");
	String pwd = request.getParameter("upwd");
	
	String sql = "select * from anli where name = ? and pwd = ?";
	List<Object> list = new ArrayList<Object>();
	list.add(name);
	list.add(pwd);
	
	List<UserBean> list2 = new DBHelper().find(sql,UserBean.class,list);
	if(list2.size() == 1){ 	//登录成功
		session.setAttribute("username", name);
		request.getRequestDispatcher("jsp03_addNews.jsp").forward(request,response);
	}else{
		String a="0";
		if(name == null && "".equals(name)){
			session.setAttribute("count", a);
		}else{
			Integer s = Integer.parseInt(a);
			s++;
			session.setAttribute("count",s.toString());
		}
		
		
		request.setAttribute("message", "账号或密码错误");
		request.getRequestDispatcher("jsp03_newsIndex.jsp").forward(request,response);
	}
	
%>