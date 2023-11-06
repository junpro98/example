<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jun.spring.repository.*" %>
<%@ page import="com.jun.spring.vo.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	List<NewVO> list = (List<NewVO>)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++) {
	int num = (list.get(i).getFilednum());
	String id = (list.get(i).getId());
	String name = (list.get(i).getName());
	String pw = (list.get(i).getPw());
	String date = (list.get(i).getDate());
		out.println("pk값 : " + num);
		out.println("아이디 : " + id);
		out.println("이름 : " + name);
		out.println("생년월일 : " + date);
		%>
    <form action="delete" method="post">
        <input type="hidden" name="pk" value="<%= num %>">
        <input type="button" name="delete_btn" value="삭제" onclick="submitForm('<%= num %>')">
    </form>
<%
    out.println("<br>");
}
%>

<script>
function submitForm(pk) {
    var form = document.createElement('form');
    form.action = 'delete'; // 삭제 처리를 담당하는 서블릿 또는 JSP 페이지 URL로 설정
    form.method = 'post';
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'pk';
    input.value = pk;
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}
</script>
</body>
</html>