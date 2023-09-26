package com.junpro.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.dto.UserDTO;
import com.junpro.mybatis.Sql_select;



public class ControlUser extends HttpServlet{

	@Override
//	form 옆에있는 메소드인 get, post를 servlet에서는 doget or dopost을 사용했는데
//	form옆에 있는 메소드 get, post가 없으면 service를 사용하면 된다.
	protected void service(HttpServletRequest rq, HttpServletResponse rs) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Sqlextract sqle = null;
		sqle = Sqlextract.instance();
		
		try {
			String servlet1 = sqle.sqlData(rq, rs);
//			List<UserDTO> list = (List) rq.getAttribute("servlet1");
			RequestDispatcher re = rq.getRequestDispatcher("link_ex1.jsp");
			re.forward(rq, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}