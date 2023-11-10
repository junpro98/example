package com.jun.spring.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.jun.spring.vo.DeleteVO;
import com.jun.spring.vo.DetailVO;
import com.jun.spring.vo.LoginVO;
import com.jun.spring.vo.NewVO;

@Repository //이걸 의존성으로 작업할 걸 세팅 해둔다는 말입니다용 컨트롤러에 autowired한걸 어딘가에 쓸 거다~ 라는거임.
public class ADAO {
	
	
//	@Autowired 
//	private DataSource data;
	
	@Autowired
	private SqlSession sqlSession;
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	
	
	public List<NewVO> newVO() {
		List<NewVO> list = sqlSession.selectList("select");
		return list;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = data.getConnection(); -> sqlSession이 가져오기 떄문에 이것도 없어도 됨
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery("SELECT * FROM junpro.junpro;");
//			while(resultSet.next()) {
//				NewVO vo = new NewVO();
//				vo.setFilednum(resultSet.getInt("filednum"));
//				vo.setId(resultSet.getString("id"));
//				vo.setPw(resultSet.getString("pw"));
//				vo.setName(resultSet.getString("name"));
//				vo.setDate(resultSet.getString("date"));
//				list.add(vo);
//			}
//		} catch (Exception e) {
			// TODO: handle exception
//		} finally {
//			try {
//				resultSet.close();
//				statement.close();
//				connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
	}
	
	public void insert(NewVO vo) {
		int insert = sqlSession.insert("insert", vo);
		
//		try {
////			Class.forName("com.mysql.jdbc.Driver");
//			connection = data.getConnection();
////			Class.forName("com.mysql.jdbc.Driver");
////			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8&useUnicode=true", "root", "123456");
//			statement = connection.createStatement();
//			int i = statement.executeUpdate("INSERT into junpro.junpro(name, id, pw, date) values ('" + vo.getName() + "','" + vo.getId() + "','" + vo.getPw() + "','" + vo.getDate() +"');");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				statement.close();
//				connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
	}
	
	public void delete(DeleteVO delVO) {
		int delete = sqlSession.delete("delete", delVO);
//		try {
////			Class.forName("com.mysql.jdbc.Driver");
////			Class.forName("com.mysql.jdbc.Driver");
////			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8&useUnicode=true", "root", "123456");
//			connection = data.getConnection();
//			statement = connection.createStatement();
//			
//			int i = statement.executeUpdate("DELETE FROM junpro WHERE filednum = " + pk + " AND pw = '" + pw + "'");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		} finally {
//			try {
//				resultSet.close();
//				statement.close();
//				connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				System.out.println(e2);
//			}
//		}
	}
	
	public List<LoginVO> login(String login_id, String login_pw) {
	    Map<String, String> login = new HashMap<>();
	    login.put("id", login_id);
	    login.put("pw", login_pw);

//	    System.out.println(login);
	    
	    List<LoginVO> list = sqlSession.selectList("login", login);
		
	    return list;
	}

	public List<DetailVO> detail(String name) {
		List<DetailVO> list = sqlSession.selectList("detail", name);
		return list;
	}
}
