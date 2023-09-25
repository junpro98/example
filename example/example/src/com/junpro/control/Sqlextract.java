package com.junpro.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.mybatis.Sql_select;



//DB 처리 결과를 연결해주는 파일

public class Sqlextract implements sqlExtract1{

	@Override
	public String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		
		Sql_select select = Sql_select.instance();
		
		select.sqlSelect();
		return null;
	}

}
