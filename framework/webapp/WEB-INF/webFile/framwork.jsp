<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.framwork.spring.repository.*" %>
<%@ page import="com.framwork.spring.vo.*" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
반갑다
<br>
오늘 저녁에 유산소랑 코어운동 해야지~
<br>
벌써부터 즐겁구만
<br>
<img src="assets/images/nohog.png" />
<br>
<br>
<br>
<br>

<%
	ArrayList<NewVO> list = (ArrayList<NewVO>)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++) {
		out.println("pk값 : " + list.get(i).getFilednum());
		out.println("아이디 : " + list.get(i).getId());
		out.println("이름 : " + list.get(i).getName());
		out.println("비밀번호 : " + list.get(i).getPw());
		out.println("생년월일 : " + list.get(i).getDate());
		out.println("<br>");
	}
%>
</body>
</html>