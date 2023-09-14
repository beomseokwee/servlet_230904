package com.test3.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test3.common.MysqlService;

@WebServlet("/lesson04/delete-favorite")
public class DeleteFavorite extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 응답 생략(302)
		
		// request parameter
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		
		// 삭제 Query
		String deleteQuery = "delete  from `favorite_list` where `id` = " + id;
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// DB 연결 해제
		ms.disconnect();
		
		
		
		// redirect => 유저 목록 화면
		response.sendRedirect("/lesson04/quiz01/list.jsp");
		
	}
}