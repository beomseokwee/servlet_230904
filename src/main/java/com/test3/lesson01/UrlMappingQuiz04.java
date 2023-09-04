package com.test3.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz04")
public class UrlMappingQuiz04 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest requsest, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		// 서블릿(Servlet) : 자바 코드 + 태그
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		out.print("<html><head><title>리스트 출력</title></head><body><ul>");
		// 합계 : 55
		for (int i = 1; i<=30; i++  ) {
			out.print("<li>" + i + "번째 리스트 </li>");
		}
		
		out.print("</ul></body></html>");
	}

}