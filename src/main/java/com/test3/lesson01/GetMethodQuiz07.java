package com.test3.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/quiz07")
public class GetMethodQuiz07 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		//한글 깨짐 방지 -> HTML
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		
		// Request parameter
		String address = request.getParameter("address");
		String card = request.getParameter("card");
		int price = Integer.valueOf(request.getParameter("price"));
		
		
		// 출력
		PrintWriter out = response.getWriter();
//			
		out.print("<html><head><title>주문결과</title></head><body>");
		
		if(address.startsWith("서울시") == false) {
			out.print(address + " <b>배달 준비중</b>"+ "<br결제금액:"+price + "원");
		}else if(card.equals("신한카드")){
			out.print("결제 불가 카드 입니다");
		}else {
			out.print("배달 불가 지역입니다.");
			
		}
		

		out.print("</body></html>");
	}

}
