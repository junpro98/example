package com.junpro.example;
// DB를 위한 클래스 파일


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Example1 {
//	퍼블릭이 있어야함!
//	샐랙 이후 출력하는 메소드
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	public ArrayList<Class_more> test01() {
		ArrayList<Class_more> arrayList = new ArrayList<Class_more>();
//		여러 객체를 만들기 위해 배열 생성한거임
//		ArrayList<클래스명>해야 합니다요.
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			아래에 있는 connection 메소드를 호출한겁니다용
			connec();
			if(connection == null) {
				throw new Exception("데이터베이스 연결 안됨");
			}
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from junpro.student;");
			while(resultSet.next()) {
				Class_more class_more = new Class_more();
//				Class_more라는 클래스에서 객체를 만들어 준뒤 그 클래스에는 get,set이 있고
//				get,set을 통해 한가지가 아닌 여러가지를 받아 올 수 있기 때문이고
//				그러면 객체.set 을 하면서 세팅한다.
				class_more.setId(resultSet.getString("id"));
				class_more.setPw(resultSet.getString("passwd"));
				class_more.setName(resultSet.getString("name"));
				class_more.setYear(resultSet.getInt("year"));
				class_more.setSnum(resultSet.getString("snum"));
				class_more.setDepart(resultSet.getString("depart"));
				class_more.setMobile1(resultSet.getString("mobile1"));
				class_more.setMobile2(resultSet.getString("mobile2"));
				class_more.setAddress(resultSet.getString("address"));
				class_more.setEmail(resultSet.getString("email"));
//				class_more라는 객체를 arraylist에 추가한거임!
				arrayList.add(class_more);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
//		그러면 리턴도 기존에는 객체인 class_more였는데 객체배열에서의 객체인 arrayList로 바꿔야 하는거임.
		return arrayList;
	}

//	입력하는 메소드
	public void input(String id, String pw, String name, int year, String snum, String depart, String mobile1, String mobile2, String address, String email) {
		// TODO Auto-generated method stub
		
		try {
//			jdbc 드라이버를 클래스에 연결한다는거임
			Class.forName("com.mysql.jdbc.Driver");
//			기존에 깔았단 mysql을 클래스에서 연결한다는거임
//			아래에 있는 connection 메소드를 호출한겁니다용
			connec();
			if(connection == null) {
//				만약 연결안된다면 아래의 예외처리가 진행된다.
				throw new Exception("데이터베이스 연결 안됨");
			}
			statement = connection.createStatement();
			int i = statement.executeUpdate("insert into student(id, passwd, name, year, snum, depart, mobile1, mobile2, address, email) values ('" + id + "','" + pw + "','" + name + "','" + year + "','" + snum + "','" + depart + "','" + mobile1 + "','" + mobile2 + "','" + address + "','" + email + "');");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close();
		}
	}
	
//	샐랙, 입력하는 메소드에서 close가 중복이기 떄문에 따로 메소드로 빼서 거기서 close해준다.

	public void close() {
		try {
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	getConnection도 중복이기 떄문에 뺄 수 있다.
//	그러면 getConnection을 기존 코드에서 지우고 메소드를 호출하면 된다.
	public void connec() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junpro?characterEncoding=utf-8", "root", "simpsons514!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}