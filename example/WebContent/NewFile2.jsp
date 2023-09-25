<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.junpro.example.Class_more" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.junpro.example.Example1"%>
<%
	String info = request.getParameter("id");
	Example1 ex = new Example1();
	ArrayList<Class_more> arr = ex.test01();
	
	Class_more selectInfo = null;
	for (Class_more selected : arr) {
		if(selected.getId().equals(info))
			selectInfo = selected;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("<table border=1>");
	out.println("<tr>");
	out.println("<th>아이디</th>");
	out.println("<th>비밀번호</th>");
	out.println("<th>이름</th>");
	out.println("<th>학번</th>");
	out.println("<th>학과번호</th>");
	out.println("<th>학과</th>");
	out.println("<th>전화번호 앞자리</th>");
	out.println("<th>전화번호 뒷자리</th>");
	out.println("<th>주소</th>");
	out.println("<th>이메일</th>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>" + selectInfo.getId()  + "</td>");
	out.println("<td>" + selectInfo.getPw()  + "</td>");
	out.println("<td>" + selectInfo.getName()  + "</td>");
	out.println("<td>" + selectInfo.getYear()  + "</td>");
	out.println("<td>" + selectInfo.getSnum()  + "</td>");
	out.println("<td>" + selectInfo.getDepart()  + "</td>");
	out.println("<td>" + selectInfo.getMobile1()  + "</td>");
	out.println("<td>" + selectInfo.getMobile2()  + "</td>");
	out.println("<td>" + selectInfo.getAddress()  + "</td>");
	out.println("<td>" + selectInfo.getEmail()  + "</td>");
	out.println("</tr>");
	out.println("</table>");
%>
</body>
</html>