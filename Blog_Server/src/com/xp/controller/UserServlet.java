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
 * �û�Servlet ������½ ע�� ��ѯ �˳� ��������  ʹ��op�ֶα�ʶҵ���������
 */
@WebServlet("/user.s")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz = new UserBiz();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// ��ȡop��ֵ
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
			msg="ɾ���ɹ�";
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
				msg = "��Ϣ����ɹ�";				
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
		//��user���ظ�����
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
		//���ղ���
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
				
	//	Map<String, String> ret = null;
		User ret = null;
		try {
			ret = ubiz.login(username, userpwd);
		} catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			//ʧ��
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(ret == null ){	// ��½ʧ�� 
			request.setAttribute("msg", "�û�����������󣡣�");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {		// ��½�ɹ�
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
