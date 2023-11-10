<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jun.spring.repository.*"%>
<%@ page import="com.jun.spring.vo.*"%>
<%@ page import="java.util.*"%>
<%
	List<LoginVO> list = (List<LoginVO>) request.getAttribute("list");
	List<NewVO> list1 = (List<NewVO>) request.getAttribute("list1");
	String sessionId = (String) session.getAttribute("sessionId");
	String sessionPw = (String) session.getAttribute("sessionPw");
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
	<table style="border: 1px solid black">
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
			<tr>
				<td onclick="location.href='detail?name=<%= name %>'" style="cursor: pointer;"><%=name%></td>
				<td><%=id123%></td>
				<td><%=pw123%></td>
			</tr>
		</tbody>
		<%
			}
		%>
	</table>
</body>
</html>