package com.junpro.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.dto.UserDTO;
import com.junpro.mybatis.Sql_select;


//DB 처리 결과를 연결해주는 파일

public class Sqlextract implements sqlExtract1{
	
//	이것도 싱글 턴 패턴으로 sel을 리턴을 해서 instance를 다른 곳에서 사용 할 수있다.
	static Sqlextract sel = new Sqlextract();
	public static Sqlextract instance() {
		return sel;
	}
	
	@Override
	public String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
//		오버라이드 한 이유는 implements를 하면 재정의 해야하기 때문에 다시 재정의 해준다.
		Sql_select select = Sql_select.instance();
		
		List<UserDTO> list = select.sqlSelect(); // select 쿼리문이 있는 클래스의 객체 메소드 호출
//		여기도 servlet 가 있기 때문에 서블릿 페이지기 때문에 이거랑 controlUser랑 이어져 있기 때문에 
//		setAttribute를 사용하면 된다.
		rq.setAttribute("List", list);
		return null;
	}

}