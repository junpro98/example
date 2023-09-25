package com.junpro.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Input_info2 {
	public void input(String id, String pw, String name, int year, String snum, String depart, String mobile1, String mobile2, String address, String email) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
//			jdbc 드라이버를 클래스에 연결한다는거임
			Class.forName("com.mysql.jdbc.Driver");
//			기존에 깔았단 mysql을 클래스에서 연결한다는거임
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8", "root", "simpsons514!");
			if(connection == null) {
//				만약 연결안된다면 아래의 예외처리가 진행된다.
				throw new Exception("데이터베이스 연결 안됨");
			}
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into student(id, passwd, name, year, snum, depart, mobile1, mobile2, address, email) values ('" + id + "','" + pw + "','" + name + "','" + year + "','" + snum + "','" + depart + "','" + mobile1 + "','" + mobile2 + "','" + address + "','" + email + "');");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
