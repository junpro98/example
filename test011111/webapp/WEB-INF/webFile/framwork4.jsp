<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String sessionId = (String) session.getAttribute("sessionId");
		String sessionPw = (String) session.getAttribute("sessionPw");
	%>
	<form action="check" method="post">
		<input type="password" placeholder="비밀번호를 입력해주세요" name="pw"> 
		<input type="hidden" name="<%=name%>" value="name"> 
		<input type="submit" value="확인">
	</form>
</body>
</html>