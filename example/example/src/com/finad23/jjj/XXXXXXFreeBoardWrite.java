package com.finad23.jjj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.finad23.DTO.BoardDTO;


public class XXXXXXFreeBoardWrite {
	public void freeBoardWrite(BoardDTO boardDTO) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
			statement = connection.createStatement();
			statement.executeUpdate("insert into freeboard(freeboardWriter, freeboardName, freeboardText, freeboardDate, freeboardViews) values ('"
					+ boardDTO.getName() + "','"
					+ boardDTO.getDate() + "','"
					+ boardDTO.getWriter() + "','"
					+ boardDTO.getText() + "'"
					+ 0 + ");"); //작동 안함 sql에서 not null설정후 default값 0으로 설정해서 자동으로 0 들어가게 설정됨
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				connection.close();				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	

}
