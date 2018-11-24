package com.xp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.bean.User;
import com.xp.bean.columns;
import com.xp.biz.categoryBiz;
import com.xp.dao.dbhelper.BeanUtils;

/**
 * 
 */
@WebServlet("/category.s")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("query".equals(op)) {
			query(request,response);
		}else if("add".equals(op)) {
			add(request,response);
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			categoryBiz catb = new categoryBiz();
			columns columns = BeanUtils.asBean(request, columns.class);
			catb.add(columns);
			query(request,response);
	}

	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		categoryBiz cat = new categoryBiz();
		request.setAttribute("categroyList", cat.findAll());		
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
