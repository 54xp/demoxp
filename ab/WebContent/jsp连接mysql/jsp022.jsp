<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%
	//进行判断 判断用户是否登录
	String admin = (String)session.getAttribute("admin");
	if(!"".equals(admin) && admin !=null){  //是已登录状态
		// 如果登录，跳转到详情界面
		request.getRequestDispatcher("jsp023.jsp").forward(request, response);
	}else{  // 未登录
			// 如果未登录 ，弹窗提示登录 且跳转到登录界面
		out.print("<script type=\"text/javascript\">alert('请先登录');location.href='./jsp02.jsp'</script>");
	}
	
%>