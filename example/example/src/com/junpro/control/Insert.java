package com.junpro.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.dto.UserDTO;
import com.junpro.mybatis.Sql_insert;

// DB처리하는 파일
public class Insert implements sqlExtract1{

	static Insert insert = new Insert();
	public static Insert instance() {
		return insert;
	}
	
	
	@Override
	public String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
		String id = rq.getParameter("id");
		String pw = rq.getParameter("pw");
		String sex = rq.getParameter("sex");
		String email = rq.getParameter("eMail");
		String nickname = rq.getParameter("nickName");
		String newsagnecy =  rq.getParameter("newsAgency");
		String mobilenumber = rq.getParameter("mobileNumber");
		String category = rq.getParameter("category");
		String post = rq.getParameter("post");
		String address = rq.getParameter("address");
		String addr_more = rq.getParameter("addr_more");
		String reference = rq.getParameter("reference");
		
		UserDTO userDTO = new UserDTO();
	
	
		

		try {
			
			Sql_insert inse = Sql_insert.instance();
			
			inse.sqlInsert(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
		
		
		return null;
	}

	
}
