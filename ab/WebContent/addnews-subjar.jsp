<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="dao.DBHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 工厂模式
	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
	//设置文件处理器的一些属性 
	upload.setFileSizeMax(1024*1024*5);  //设置单个上传文件的大小  5M
	upload.setSizeMax(1024*1024*30);  // 设置所有文件的总大小
	// 把每一个表单对象封装成一个一个的FileItem 对象
	List<FileItem> list = upload.parseRequest(request);
	
	String sql = "insert into news(ntid,ntitle,nauthor,nsummary,ncontent,file) values(?,?,?,?,?,?)";
	List<Object> list2 = new ArrayList<Object>();
	// 循环解读集合属性
	for(FileItem item:list){
		// 普通表单对象
		if(item.isFormField()){
			if("ntid".equals(item.getFieldName())){
				list2.add(item.getString("utf-8"));
			}
			if("ntitle".equals(item.getFieldName())){
				list2.add(item.getString("utf-8"));
			}
			if("nauthor".equals(item.getFieldName())){
				list2.add(item.getString("utf-8"));
			}
			if("nsummary".equals(item.getFieldName())){
				list2.add(item.getString("utf-8"));
			}
			if("ncontent".equals(item.getFieldName())){
				list2.add(item.getString("utf-8"));
			}
		}else{  
			// 文件对象
			String fileName = item.getName();   //文件名
			InputStream in = item.getInputStream();	
			if(fileName.contains("\\")){
				fileName = fileName.substring(fileName.lastIndexOf("\\"),fileName.length());
			}
			byte[] buffer = new byte[1024];
			int length = 0;
			//存放本地文件的目录
			String local = "E:\\2_JDK\\"+fileName;
			OutputStream ou = new FileOutputStream(local);
			while((length = in.read(buffer))!=-1){
				ou.write(buffer, 0, length);
			}
			ou.close();
			in.close();
			
			list2.add("E:\\2_JDK\\"+fileName);
		}
	}
	
	int i = new DBHelper().update(sql, list2);
	if(i>0){ //新增成功
		response.sendRedirect("jsp03_addNews.jsp");
	}
	
%>