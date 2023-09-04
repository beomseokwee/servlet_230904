package com.test3.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz10")
public class  PostMethodQuiz10 extends HttpServlet {
	
	
	private final Map<String, String> userMap =  new HashMap<String, String>() {
	    {
	        put("id", "wbs001");
	        put("password", "1234");
	        put("name", "위범석");
	    }
	};
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// HTML
		response.setContentType("text/html");

		// Request Params
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
	
		// 출력
		PrintWriter out = response.getWriter();
//		List<String> valueList = new ArrayList<>(userMap.values());
		
//		for (String key : userMap.values()) {
//			  out.print(key);
//			}
//		
		
		out.print("<html><head><title>회원 정보</title></head><body>");
		
		if(userMap.get("id").equals(id) && userMap.get("password").equals(password) ) {
			out.print(userMap.get("name")+ "님 환영합니다!!");
			
		}else if(userMap.get("id").equals(id) == false) {
			out.print("id가 일치하지 않습니다.");
		}
		else {
			out.print("password가 일치하지 않습니다.");
			
		}
		out.print("</body></html>");
		
	}
	
	
}
