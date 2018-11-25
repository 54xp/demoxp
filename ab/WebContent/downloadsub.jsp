<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    	// 通过程序的方式，写数据到浏览器，通知浏览器进行下载
    		1、告诉浏览器，这个文件是个下载文件， contentType 的一个文件类型来确定
    			text/html 普通的html页面格式的数据
    			application/x-msdownload  告诉浏览器这是一个下载的文件
    		2、通知客户端，不由浏览器来操作，由用户来操作
    		  设置请求头 Content-Disposition  标准格式数据为 "attachment;filename="+文件名
     -->
<% 
	response.setContentType("application/x-msdownload");
	// 创建一个流，往浏览器写数据	
	String fileName = "E:\\readme.txt";
	// 中文文件名处理 
	// url编码  URLEncoder.encode(fileName,"utf-8")
	response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName,"utf-8"));
	
	// 通过流的方式回写数据到浏览器
	OutputStream ou = response.getOutputStream();
	// 读取本地的一个流
	InputStream in = new FileInputStream(fileName);
	byte[] buffer = new byte[1024];
	int len =0;
	while((len=in.read(buffer))!=-1){
		ou.write(buffer,0,len);
	}
	ou.close();
	in.close();
%>