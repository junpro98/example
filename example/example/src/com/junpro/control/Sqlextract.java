package com.junpro.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.dto.UserDTO;
import com.junpro.mybatis.Sql_select;


//DB 처리 결과를 연결해주는 파일

public class Sqlextract implements sqlExtract1{

	static Sqlextract sel = new Sqlextract();
	public static Sqlextract instance() {
		return sel;
	}
	
	@Override
	public String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		
		Sql_select select = Sql_select.instance();
		
		List<UserDTO> list = select.sqlSelect(); // select 쿼리문이 있는 클래스의 객체 메소드 호출
//		여기도 servlet 가 있기 때문에 서블릿 페이지기 때문에 이거랑 controlUser랑 이어져 있기 때문에 
//		setAttribute를 사용하면 된다.
		rq.setAttribute("List", list);
		return null;
	}

}