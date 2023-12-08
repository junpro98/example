<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글이 삭제 되었습니다.
<form action="index" method="post">
	<input type="button" value="돌아가기" name="button" onclick="show()">
</form>
<script>
	function show(button) {
		window.location.href = "index";
	}
</script>
</body>
</html>