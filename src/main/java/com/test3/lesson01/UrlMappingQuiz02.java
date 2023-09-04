package com.test3.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingQuiz02 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글깨짐 방지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		// 시간 생성
		
		Date now = new Date();
		
		// 포맷 정의 출력
		PrintWriter out = response.getWriter();
		out.print("현재 시간은 ");
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		out.print(sdf.format(now));
		out.print("입니다.");
		
	}

}
