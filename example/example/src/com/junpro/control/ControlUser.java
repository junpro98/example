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

		String control =  rq.getParameter("control"); // 다음 페이지로 넘어갈 때 ?control에서 control을 parameter로 받아옴
		sqlExtract1 sqle = null; // 인터페이스용 주머니 생성
		
		
		try {
			if(control.equals("select")) {
				
				sqle = Sqlextract.instance(); // select용 인터페이스
				sqle.sqlData(rq, rs);
				RequestDispatcher re = rq.getRequestDispatcher("link_ex1.jsp");
//				link_ex1.jsp로 넘겨 주면 된다.
				re.forward(rq, rs);	
			} else if(control.equals("insert")) {
				sqle = Insert.instance(); // insert용 인터페이스
				sqle.sqlData(rq, rs); 
				RequestDispatcher re = rq.getRequestDispatcher("link_ex3.jsp");
				re.forward(rq, rs);	
				
			} else {
				System.out.println("연결안됨.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}