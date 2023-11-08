<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jun.spring.repository.*"%>
<%@ page import="com.jun.spring.vo.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String id = request.getParameter("login_id");
	String pw = request.getParameter("login_pw");
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	List<LoginVO> list = (List<LoginVO>) request.getAttribute("list");
	List<NewVO> list1 = (List<NewVO>) request.getAttribute("list1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1><%=list.get(0).getName()%>님 반갑습니다!
	</h1>
	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>작성일</th>
			</tr>
		</thead>
		<%
			for (int i = 0; i < list1.size(); i++) {
				String name = list1.get(i).getName();
				String id123 = list1.get(i).getId();
				String pw123 = list1.get(i).getPw();
		%>
		<tbody>
			<tr onclick="location.href='detail'" style="cursor:pointer;">
				<td><%= name%></td>
				<td><%= id123%></td>
				<td><%= pw123%></td>
			</tr>
		</tbody>
		<%
			}
		%>
	</table>
</body>
</html>