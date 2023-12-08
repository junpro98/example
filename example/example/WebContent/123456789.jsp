<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1234
<%
         String DB_URL = "jdbc:mysql://52.79.243.19:3306/test?";
         String DB_USER = "project";
         String DB_PASSWORD= "123456";

         ResultSet rs = null;
         Connection conn;
         Statement stmt;

         try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                stmt = conn.createStatement();
                out.println("MySQL Connection Success!");

         }

         catch(Exception e){
        	 System.out.println(e);
         }
%>
</body>
</html>