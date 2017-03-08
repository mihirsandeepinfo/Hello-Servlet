package com.mihir.servlet.tutorial;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/exampleInfo")
public class ExampleInfoServlet extends HttpServlet {
	
	private static final long servialVersionUID = 1L;
	public ExampleInfoServlet(){
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletOutputStream out = response.getOutputStream();
		out.println("<style>span{color:blue;}</style>");
		
		String requestURL =request.getRequestURL().toString();
		out.println("<br><span>reuestURL:</span>");
		out.println(requestURL);
		
		String requestURI =request.getRequestURI().toString();
		out.println("<br><span>reuestURI:</span>");
		out.println(requestURI);
		
		out.println("<br><span>remoteHost:</span>");
		String remoteHost = request.getRemoteHost();
		out.println(remoteHost);
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = headers.nextElement();
			out.println("<br><span>"+header+"</span>: "+request.getHeader(header));
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doGet(request, response);
	}
	
}
