package com.test3.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test3.common.MysqlService;

@WebServlet("/lesson04/quiz01")


public class quiz01 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 응답값 plain
        response.setContentType("text/plain");
        
        
        MysqlService ms = MysqlService.getInstance(); // DB 연결을 위한 객체 생성(싱글턴이라 한개만 생성됨)
        ms.connect(); // DB 연결

        
        
        
        //-- 쿼리 수행
        // select
        
        String insertQuery = "insert into `real_estate`\r\n"
        		+ "(`realtorid`,`address`,`area`,`type`,`price`)\r\n"
        		+ "values\r\n"
        		+ "(3,'헤라펠리스 101동 5305호	',350,'매매',1500000)";
        
        try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String selectQuery = "select `address`,`area`,`type` from `real_estate` order by `id` desc limit 10";
        
        
        
        PrintWriter out = response.getWriter();
        ResultSet res;
        try {
            res = ms.select(selectQuery);
            while (res.next()) {  // 결과 행이 있는 동안 수행
            	
            	String address = res.getString("address");
            	int area = res.getInt("area");
            	String type = res.getString("type");
                out.println("매물 주소 : " + address + ", 면적: "+ area + ", 타입: "+ type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //-- 쿼리 끝

        ms.disconnect(); // DB 연결 해제
    }

}
