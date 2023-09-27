package com.junpro.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junpro.dto.UserDTO;
import com.junpro.mybatis.Sql_insert;

// DB처리하는 파일
public class Insert implements sqlExtract1{
// 싱글톤 패턴 좀 더 익숙해 질때 까지 코드 계속 반복 작업 해 봐야 할듯.
	static Insert insert = new Insert();
	public static Insert instance() {
		return insert;
	}
	
	
	@Override
	public String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		// TODO Auto-generated method stub
//		서블릿 파일에서 rq, rs를 매게변수로 받아와서 여기서 처리
		String InfulUserId = rq.getParameter("id");
		String password = rq.getParameter("password");
		String name = rq.getParameter("name");
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
		
		UserDTO user = new UserDTO();
//		화요일에 내가 dto에 생각을 안하고 바로 get~~~을 했는데 생각해보면
//		get이 아닌 set을 해야지 dto에 저장이 되면서 이걸 xml파일에 들고 갈 수 있을거 같음.
		user.setInfluUserId(InfulUserId);
		user.setPassword(password);
		user.setName(name);
		user.setSex(sex);
		user.seteMail(email);
		user.setNickName(nickname);
		user.setNewsAgency(newsagnecy);
		user.setMobileNumber(mobilenumber);
		user.setCategory(category);
		user.setPost(post);
		user.setAddress(address);
		user.setAddr_more(addr_more);
		user.setReference(reference);

		Sql_insert inse = Sql_insert.instance();
		inse.sqlInsert(user);

		
		
		return null;
	}

	
}
