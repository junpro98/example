package com.junpro.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlUser extends HttpServlet{

	@Override
//	form 옆에있는 메소드인 get, post를 servlet에서는 doget or dopost을 사용했는데
//	form옆에 있는 메소드 get, post가 없으면 service를 사용하면 된다.
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		sqlExtract1 sqle = null;
		try {
			sqle.sqlData(arg0, arg1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		super.service(arg0, arg1);
		
		
	}
	
	
	
}
