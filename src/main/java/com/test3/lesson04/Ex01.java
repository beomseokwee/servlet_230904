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

@WebServlet("/lesson04/ex01")
public class Ex01 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        MysqlService mysqlService = MysqlService.getInstance(); // DB 연결을 위한 객체 생성(싱글턴이라 한개만 생성됨)
        mysqlService.connect(); // DB 연결

        //-- 쿼리 수행
        // select
        String selectQuery = "select * from used_goods";

        PrintWriter out = response.getWriter();
        ResultSet resultSet;
        try {
            resultSet = mysqlService.select(selectQuery);
            while (resultSet.next()) {  // 결과 행이 있는 동안 수행
                out.println(resultSet.getInt("id"));
                out.println(resultSet.getString("title"));
                out.println(resultSet.getInt("price"));
                out.println(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //-- 쿼리 끝

        mysqlService.disconnect(); // DB 연결 해제
    }
}