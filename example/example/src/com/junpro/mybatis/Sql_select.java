package com.junpro.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.junpro.dto.UserDTO;


// DB 연결하는 파일
public class Sql_select {
//	이것도 객체를 사용할려면 여려번 생성 해줘야 하기 때문에 싱글턴 패턴을 사용한거임
	static Sql_select sel = new Sql_select();
	public static Sql_select instance() {
		return sel;
	}
	
	
	
//	DB를 연결합니다용
	SqlSessionFactory sqlsession = Sqlcontrol.getSqlSession();
	
	public List sqlSelect() {
//		openSession으로 session을 연다
//		import 를 확인하자
		SqlSession session = sqlsession.openSession();
		List<UserDTO> list = session.selectList("selectId"); // select한 정보에 해당하는 부분이 저장된거임 
		session.close();
		return list;

	}
}