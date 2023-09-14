package com.test3.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test3.common.MysqlService;

@WebServlet("/lesson04/add-favorite")
public class addFavorite extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//응답 정의 생략(302)
		
		// request parameters
		String name = request.getParameter("name");
		String url = request.getParameter("url");
	
		
		//DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		
		// DB insert
		String insertQuery = "insert into `favorite_list` (`name`,`url`)"
				+ "values ('"+ name + "' , '" + url + "')";
		
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DB 연결 해제
		ms.disconnect();
		// 리다이렉트(Redirect) => 유저목록 화면 이동
		response.sendRedirect("/lesson04/quiz01/list.jsp");
	}

}
