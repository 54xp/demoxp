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
 * ����Ȩ�޿��ƵĹ�����
 * @author lenovo
 *
 */
@WebFilter(urlPatterns= {"*.jsp","*.s"})
public class LoginFilter implements Filter {
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		// ʵ���ų�Ȩ�޷��ʿ��Ƶ���Դ
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		//��ȡ��ǰ������Դ��
		String path = httpRequest.getServletPath();
	//	System.out.println(path); 
		// �ж���Դ�Ƿ���Ҫ����
		if(path.endsWith("user.s") || path.endsWith("login.jsp")) {
			// login.s �� login.jsp ����ֱ�ӷ���    login.jsp��½����
			chain.doFilter(request, response);
			return;
		}
	//	System.out.println(httpRequest.getSession().getAttribute("loginedUser"));
		if(httpRequest.getSession().getAttribute("loginedUser") !=null){
			// �ѵ�½  ������
			chain.doFilter(request, response);
		}else {  // δ��½ ,��ת��½ҳ
			request.setAttribute("msg", "���ȵ�¼ϵͳ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
