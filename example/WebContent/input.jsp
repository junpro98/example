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
<jsp:useBean id="student" class="com.junpro.example.Example1" scope="page"/>
<%
			/* requset.getParameter를 통해서 앞에 html에서 입력된걸 받아온다. */
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			/* request.getParameter는 string형태기 때문에 형변환 해준거임 */
		    int year = new Integer(request.getParameter("year"));
			String snum = request.getParameter("snum");
			String depart = request.getParameter("depart");
			String mobile1 = request.getParameter("mobile1");
			String mobile2 = request.getParameter("mobile2");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			
			/* useBean을 통해서 객체인 student를 생성했고 클래스의 메소드인 input을 찍은뒤, 안에 */
			/* request.getParmeter한걸 넣어준다. */
 			student.input(id, pw, name, year, snum, depart, mobile1, mobile2, address, email);
			response.sendRedirect("NewFile.jsp");
%>
</body>
</html>