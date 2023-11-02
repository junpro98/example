package com.framwork.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.framwork.spring.vo.NewVO;

@Repository //이걸 의존성으로 작업할 걸 세팅 해둔다는 말입니다용 컨트롤러에 autowired한걸 어딘가에 쓸 거다~ 라는거임.
public class ADAO {
	
	public ArrayList<NewVO> newVO() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<NewVO> list = new ArrayList<NewVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8", "root", "123456");
			if(connection == null) {
				throw new Exception("데이터베이스 연결 안됨.");
			}
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM junpro.junpro;");
			while(resultSet.next()) {
				NewVO vo = new NewVO();
				vo.setFilednum(resultSet.getInt("filednum"));
				vo.setId(resultSet.getString("id"));
				vo.setPw(resultSet.getString("pw"));
				vo.setName(resultSet.getString("name"));
				vo.setDate(resultSet.getString("date"));
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	
	public void insert(NewVO vo) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8&useUnicode=true", "root", "123456");
			if(connection == null) {
				throw new Exception("데이터베이스 연결 안됨<br>");
			}
			statement = connection.createStatement();
			int i = statement.executeUpdate("INSERT into junpro.junpro(name, id, pw, date) values ('" + vo.getName() + "','" + vo.getId() + "','" + vo.getPw() + "','" + vo.getDate() +"');");
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void delete(String pw, String pk) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		System.out.println(pw);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8&useUnicode=true", "root", "123456");
			if(connection == null) {
				throw new Exception("데이터베이스 연결 안됨");
			}
			statement = connection.createStatement();
			
			int i = statement.executeUpdate("DELETE FROM junpro WHERE filednum = " + pk + " AND pw = '" + pw + "'");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
	}
	
}
