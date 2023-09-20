package com.test3.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test3.common.MysqlService;

@WebServlet("/lesson04/quiz02/insert_goods")
public class ServletDBQuiz02 extends HttpServlet {
	@Override 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String imageUrl = request.getParameter("imageUrl");
		String description = request.getParameter("description");
		int sellerId = Integer.valueOf(request.getParameter("sellerId"));
		
		MysqlService mysqlService = new MysqlService();
		mysqlService.connect();
		
		String query = "insert into `used_goods`"
				+ "(`sellerId`, `title`, `price`, `description`, `picture`)"
				+ "values"
				+ "(" + sellerId + ", '" + title + "', " + price + ", '" + description + "', '" + imageUrl + "')";
		
		//System.out.println(query);
		
		try {
			mysqlService.update(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		mysqlService.disconnect();
		
		response.sendRedirect("/lesson04/quiz03/list_template.jsp");
	}
}