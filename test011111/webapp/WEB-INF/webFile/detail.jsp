<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jun.spring.repository.*"%>
<%@ page import="com.jun.spring.vo.*"%>
<%@ page import="java.util.*"%>
<%
	String name = request.getParameter("name");
	List<DetailVO> list = (List<DetailVO>) request.getAttribute("name");
	String sessionId = (String) session.getAttribute("sessionId");
	String id = list.get(0).getId();
	String pw = list.get(0).getPw();
	String name11 = list.get(0).getName();
	String date = list.get(0).getDate();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : <%=id%><br> 
	비밀번호 : <%=pw%><br>
	 이름 : <%=name11%><br>
	 가입일 : <%=date%><br>
	<%
		if (sessionId.equals(id)) {
	%>
	<form action="delete" method="post">
		<input type="button" value="삭제" name="delete3" onclick="delete1('<%= pw%>')">
		<input type="hidden" value="<%= name %>" name="name">		
	</form>
	<form action="fileup" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="hidden" name="id" value="<%= id%>">
		<input type="submit" value="첨부파일 업로드하기">
	</form>
	<%
		}
	%>
	<script>
		function delete1(delete3) {
			var form = document.createElement("form");
			form.action="delete";
			form.method="post";
			var input = document.createElement("input");
			input.type="button";
			input.name="delete";
			input.value="삭제";
			var input1 = document.createElement("hidden");
			input1.type="hidden";
			input1.name="name";
			input1.value="name";
			form.appendChild(input,input1);
			document.body.appendChild(form);
			form.submit();
		}
	</script>
</body>
</html>