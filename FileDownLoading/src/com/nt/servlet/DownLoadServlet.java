package com.nt.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		ServletContext sc=null;
		File file=null;
		String path=null;
		long length=0;
		String mimeType=null;
		InputStream is=null;
		ServletOutputStream sos=null;
		byte[] buffer=new byte[4096];
		int bytesRead=0;
		//get servletContext
		sc=getServletContext();
		//get path of file to be download
		path=sc.getRealPath("/ravli.jpg");
		//get length of the file and make it as the response content length
		file=new File(path);
		res.setContentLengthLong(length);
		//get the mimeType of the file and make it as response mime type
		mimeType=sc.getMimeType("ravali.jpg");
		res.setContentType(mimeType);
		//set content disposition response header
		res.setHeader("content-disposition", "attachment;fileName=ravali.jpg");
		//create input stream pointing to the file
		//is.getResourceAsStream("ravali.jpg");
	
		//get output stream pointing to the response obj
		sos=res.getOutputStream();
		
		
		is=sc.getResourceAsStream("ravali.jpg");
		//write buffer based logic to complete file copy activity(file downloading)
	while((bytesRead=is.read(buffer))!=-1){
			sos.write(buffer,0,bytesRead);
			
		}//while
		//close stream
		is.close();
		sos.close();
	}
		 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
			doPost(req,res);
		
		}
	

}//class
