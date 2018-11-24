package com.xp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.xp.bean.User;
import com.xp.biz.BizException;
import com.xp.biz.UserBiz;
import com.xp.dao.dbhelper.BeanUtils;

/**
 * 用户Servlet 包含登陆 注册 查询 退出 忘记密码  使用op字段标识业务操作类型
 */
@WebServlet("/user.s")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz = new UserBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 获取op的值
		String op = request.getParameter("op");
		if("login".equals(op)) {
			login(request,response);
		}else if("query".equals(op)) {
			query(request,response);
		}else if("add".equals(op)) {
			add(request,response);
		}else if("find".equals(op)) {
			find(request,response);
		}else if("save".equals(op)) {
			save(request,response);
		}else if("delete".equals(op)) {
			delete(request,response);
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String  msg="";
		 try {
			ubiz.delete(id);
			msg="删除成功";
		} catch (BizException e) {
			e.printStackTrace();
			msg=e.getMessage();
		}
		 response.getWriter().append(msg);
	}
	private void save(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			User user = BeanUtils.asBean(request, User.class);			
			String msg="";
			try {
				ubiz.save(user);
				msg = "信息保存成功";				
			} catch (BizException e) {
				e.printStackTrace();
				msg = e.getMessage();				
			}
			response.getWriter().append(msg);			
			}
	private void find(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");		
		User user = ubiz.findById(id);
		//将user传回给界面
		String userString = JSON.toJSONString(user);
		response.getWriter().append(userString);
	}
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException  {
		{			
			User user = BeanUtils.asBean(request, User.class);
			try {
				String repwd = request.getParameter("repwd");
				ubiz.add(user,repwd);
			} catch (BizException e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
			}finally {
				query(request,response);
			}
		}
	} 
	private void query(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		User user = BeanUtils.asBean(request, User.class);
		request.setAttribute("userList",ubiz.find(user));
		request.getRequestDispatcher("manage-user.jsp").forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接收参数
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
				
	//	Map<String, String> ret = null;
		User ret = null;
		try {
			ret = ubiz.login(username, userpwd);
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			//失败
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(ret == null ){	// 登陆失败 
			request.setAttribute("msg", "用户名或密码错误！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {		// 登陆成功
			request.getSession().setAttribute("loginedUser",ret);
	//		System.out.println(request.getSession().getAttribute("loginedUser")+"====");
			response.sendRedirect("index.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
