<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="input01" class="com.junpro.example.Input_info2"></jsp:useBean>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int year = new Integer(request.getParameter("year"));
	String snum = request.getParameter("snum");
	String depart = request.getParameter("depart");
	String mobile1 = request.getParameter("mobile1");
	String mobile2 = request.getParameter("mobile2");
	String address = request.getParameter("address");
	String email = request.getParameter("email");
	
	input01.input(id, pw, name, year, snum, depart, mobile1, mobile2, address, email);
	response.sendRedirect("NewFile.jsp");
%>
</body>
</html>