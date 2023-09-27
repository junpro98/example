package com.junpro.mybatis;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.junpro.dto.UserDTO;

// DB연결하는 파일
public class Sql_insert {
	
	static Sql_insert ins = new Sql_insert();
	public static Sql_insert instance() {
		return ins;
	}
	
	
	SqlSessionFactory sqlsession = Sqlcontrol.getSqlSession();

	public void sqlInsert(UserDTO user) {
		
		SqlSession session = sqlsession.openSession(); // open을 했으면 
		
//		System.out.println(user.getInfluUserId()); // 혹시 시스템에 찍히는지 찍어봄
		
		int i = session.insert("insertId", user); // int타입으로 담아야함
//		이유는 insert 자동 완성 문구에 보면 int가 있어서 일단 int i로 담아 둔거임.
		session.commit();
		session.close(); // close를 해야한다.
	}
	
}
