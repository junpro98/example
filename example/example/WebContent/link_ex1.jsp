<%@page import="com.junpro.control.ControlUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.junpro.dto.UserDTO" %>
<%@ page import="com.junpro.control.ControlUser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<UserDTO> list = (List<UserDTO>) request.getAttribute("List");

	if(list != null) {
		for(int i = 0; i < list.size(); i++) {
			out.println(list.get(i).getInfluUserId());
			out.println(list.get(i).getPassword());
			out.println(list.get(i).getName());
			out.println(list.get(i).getSex());
			out.println(list.get(i).geteMail());
			out.println(list.get(i).getNickName());
			out.println(list.get(i).getNewsAgency());
			out.println(list.get(i).getMobileNumber());
			out.println(list.get(i).getCategory());
			out.println(list.get(i).getPost());
			out.println(list.get(i).getAddress());
			out.println(list.get(i).getAddr_more());
			out.println(list.get(i).getReference());

		}
	}
%>
</body>
</html>