package com.xp.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 访问权限控制的过滤器
 * @author lenovo
 *
 */
@WebFilter(urlPatterns= {"*.jsp","*.s"})
public class LoginFilter implements Filter {
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		// 实现排除权限访问控制的资源
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		//获取当前访问资源名
		String path = httpRequest.getServletPath();
	//	System.out.println(path); 
		// 判断资源是否需要拦截
		if(path.endsWith("user.s") || path.endsWith("login.jsp")) {
			// login.s 和 login.jsp 界面直接放行    login.jsp登陆界面
			chain.doFilter(request, response);
			return;
		}
	//	System.out.println(httpRequest.getSession().getAttribute("loginedUser"));
		if(httpRequest.getSession().getAttribute("loginedUser") !=null){
			// 已登陆  不拦截
			chain.doFilter(request, response);
		}else {  // 未登陆 ,跳转登陆页
			request.setAttribute("msg", "请先登录系统");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
