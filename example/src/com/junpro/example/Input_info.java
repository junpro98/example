package com.junpro.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Input_info{
//	input(매게변수를 넣어서 여기서도 같은 형태로 맞춰준다)
	public void input(String id, String pw, String name, int year, String snum, String depart, String mobile1, String mobile2, String address, String email) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8", "root", "simpsons514!");
			if(connection == null) {
				throw new Exception("데이터 베이스 연결 안됨.");
			}
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into student(id, passwd, name, year, snum, depart, mobile1, mobile2, address, email) values ('" + id + "','" + pw + "','" + name + "','" + year + "','" + snum + "','" + depart + "','" + mobile1 + "','" + mobile2 + "','" + address + "','" + email + "');");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
		}
	}
}
