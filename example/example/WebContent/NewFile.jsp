<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.junpro.example.Class_more" %>
<%@ page import="java.util.ArrayList" %>
<!-- usebean 대신에 import를 사용해서 클래스 사용가능. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="student" class="com.junpro.example.Example1" scope="page"></jsp:useBean>
<%
/* 클래스에서 메소드 앞에 public을 해야지 오류코드가 사라집니다 */

/* 객체 생성하듯 class명 쓰고 객체 생성 한다음에 usebean을 통해 Example1에 있는 메소트를 호출헤줌 */
/* 배열이면 import로 arraylist 달아줘야함 */
ArrayList<Class_more> moreList = student.test02();
/* set을 했기 때문에 get을 해서 들고 온다요 */
	out.println("<table border =1>");
	out.println("<tr>");
	out.println("<th>아이디</th>");
/*  	out.println("<th>비밀번호</th>");
 	out.println("<th>이름</th>");
	out.println("<th>학번</th>");
	out.println("<th>학과번호</th>");
	out.println("<th>학과</th>");
	out.println("<th>전화번호 앞자리</th>");
	out.println("<th>전화번호 뒷자리</th>");
	out.println("<th>주소</th>");
	out.println("<th>이메일</th>"); */
	out.println("</tr>");
for(int i = 0; i < moreList.size(); i++) {
	out.println("<tr>");
	 out.println("<td><a href='NewFile2.jsp?id=" + moreList.get(i).getId() + "'>" + moreList.get(i).getId() + "</a></td>");
/*  	out.println("<td>" + moreList.get(i).getPw() + "</td>");
 	out.println("<td>" + moreList.get(i).getName() + "</td>");
	out.println("<td>" + moreList.get(i).getYear() + "</td>");
	out.println("<td>"+moreList.get(i).getSnum() + "</td>");
	out.println("<td>"+moreList.get(i).getDepart()+"</td>");
	out.println("<td>"+moreList.get(i).getMobile1()+"</td>");
	out.println("<td>"+moreList.get(i).getMobile2()+"</td>");
	out.println("<td>"+moreList.get(i).getAddress()+"</td>");
	out.println("<td>"+moreList.get(i).getEmail()+"</td>"); */ 
	out.println("</tr>");
}
out.println("</table>");
%>
</body>
</html>