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
	String pk = request.getParameter("pk");
%>
<form action="check">
<input type="password" placeholder="비밀번호를 입력해주세요" name="pw">
<input type="hidden" name="pk" value="<%= pk%>">
<input type="submit" value="확인">
</form>
</body>
</html>