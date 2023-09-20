<%@page import="java.sql.ResultSet"%>
<%@page import="com.test3.common.MysqlService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<title>HONG당무 마켓</title>


<link rel="stylesheet" href="style.css" type="text/css">
</head>


<body>
<%
	// DB 연결
	MysqlService ms = MysqlService.getInstance();
	ms.connect();
	// DB select
	String selectQuery = "select  A.nickname,B.pictureUrl,B.title,B.price from seller AS A join used_goods AS B on A.id = B.sellerId order by A.id desc";
	ResultSet res = ms.select(selectQuery);
	
%>
<div class="container">
<header >
	<div class="align-middle text-center p-3 ">
		<h2 class="text-light ">Hong당무 마켓</h2>
	</div>
</header>
<nav>
<div class="d-flex justify-content-center">
	<ul class="nav nav-fill w-100">
		<li class="nav-item "><a href="/lesson04/quiz03/market.jsp" class="nav-link main-link">리스트</a></li>
		<li class="nav-item"><a href="/lesson04/quiz03/market.jsp" class="nav-link main-link">물건 올리기</a></li>
		<li class="nav-item"><a href="/lesson04/quiz03/market.jsp" class="nav-link main-link">마이 페이지</a></li>
	</ul>
	</div>
</nav>
<section class="mt-4 d-flex justify-content-center">
	<div class="d-flex flex-wrap ">

		<%
             while (res.next()) {
        %>
		<%-- goods-box가 상품 하나의 영역 --%>
		<div class="goods-box mb-3 mr-2">
			<div class="goods-image-box ">
			
				<%-- 이미지 없는 경우 --%>
				<%	if (res.getString("pictureUrl") == null || res.getString("pictureUrl").equals("")) { %>
				<div class="d-flex h-100 justify-content-center align-items-center">
					<h4 class="text-secondary">이미지 없음</h4>
				</div>
				
				<%-- 이미지 있는 경우 --%>
				<%
             		} else {
				%>
				<div class="goods-image-box">
					<img class="w-100" src="<%= res.getString("pictureUrl") %>">
				</div>             			
             	<%	
             		}
				%>
			</div>
			<div class="title mt-1"><%= res.getString("title") %></div>
			<div class="price mt-1"><%= res.getString("price") %>원</div>
			<div class="seller mt-1"><%= res.getString("nickname") %></div>
		</div>
		<% 	} %>
	</div>
</section>
<footer class="text-center">

<hr>
	<small class=" text-secondary">Copyright © marondal 2021</small>

</footer>

<%
	// DB 연결 해제
	ms.disconnect();
%>
</div>
</body>
</html>