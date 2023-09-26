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

	public void sqlInsert(UserDTO userDTO) {
		
		SqlSession session = sqlsession.openSession();
		session.insert("insertId");

		session.close();
	}
	
}
