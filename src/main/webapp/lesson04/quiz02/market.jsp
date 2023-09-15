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
</head>
<style>


header {height:80px; background-color:#ff884c;}
nav {height:40px; background-color:#ff884c;}
.contents {min-height:550px; text-align:center;}
footer {height:200px  ;}
.contentBox{
	width:100%;
}
.content{
	width: 30%;
	text-align:left;
	display: block;
	float :left;
	margin-left:20px;
}

</style>
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
<div>
	<ul class="nav nav-fill w-100">
		<li class="nav-item "><a href="#" class="nav-link  text-white font-weight-bold">리스트</a></li>
		<li class="nav-item"><a href="#" class="nav-link  text-white font-weight-bold">물건 올리기</a></li>
		<li class="nav-item"><a href="#" class="nav-link  text-white font-weight-bold">마이 페이지</a></li>
	</ul>
	</div>
</nav>
<section class="contents">
<%
	while(res.next()) {
%>
<div class="contentBox">
	
	<div class="content mt-4 border border-success p-1">
		<img src="<%=res.getString("pictureUrl")%>" alt="물품사진"  width="195" />
		<div ><%=res.getString("title") %></div>
		<div ><%=res.getInt("price") +"원"%></div>
		<div ><%=res.getString("nickname") %></div>
	</div>
	
</div>

<%
	} 

%>
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