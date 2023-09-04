package com.test3.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/ex03")
public class GetMethodEx03 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지 -> plain
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/plain");
		
		//한글 깨짐 방지 -> json string
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		
		// Request Parameter
//		request.getParameter("user_id");
		String userId = request.getParameter("user_id");
		String name = request.getParameter("name");
		int age = Integer.valueOf(request.getParameter("age"));	
		// 출력
		
		PrintWriter out = response.getWriter();
		
//		JSON으로 출력
//		{"user_id":"wbs001","name":"위범석","age":30}
		out.print("{\"user_id\":\":\"" + userId + "\", \"name\":\""
				+ name + "\", \"age\":" + age + "}"
				);
		
//		out.println("userId: " +  userId);
//		out.println("name: " +  name);
//		out.println("age: " + age);
	}

}
