package com.junpro.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


// DB처리하는 파일
public class Sql_select {
//	싱글턴 패턴을 한거임. 왜냐면~ 메소드를 사용할거면 사용할때마다 객체를 만들어줘야 하는데 싱글턴 패턴을 하면 그걸 안해도 되기 때문에 한거임!
//	그걸 implements한곳에서 부르면 된다.
	static Sql_select sel = new Sql_select();
	public static Sql_select instance() {
		return sel;
	}
	
	
	
//	DB에 대한 정보는 Sqlcontorl에 있다.
	SqlSessionFactory sqlsession = Sqlcontrol.getSqlSession();
	
	public void sqlSelect() {
//		db를 만든 클래스를 오픈할거임~
//		openSession은 리턴 타입이 session이기에 리턴을 맞춰 준다.
//		import를 해야합니다! 안그러면 오류가 나와요
		SqlSession session = sqlsession.openSession();
//		select에서 여러개 하면 list 또는 map 하면 되고 하나면 one을 쓰면 된다.
//		기존 DB 연결문을 보면 statement는 executeQuery 또는 executeUpdate를 사용하기 떄문에 아래에 있는 statement에도 그거에 맞게 넣으면 된다.
		List list = session.selectList("selectId");
		session.close();
	}
	
}
