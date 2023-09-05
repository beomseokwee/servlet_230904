
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz02_1</title>
</head>
<body>
<%
Date date = new Date();

String type = request.getParameter("type");

SimpleDateFormat sdf = null;
if(type.equals("time")){
	sdf = new SimpleDateFormat("현재 시간은 HH시mm분ss초 입니다.");
}else{
	sdf = new SimpleDateFormat("현재 날짜는 yyyy년MM월dd일 입니다.");
	
}  
String result = sdf.format(date);
%>

	<div class="container">
		<div class="display-1"><%=result %></div>
	</div>

</body>


</html>