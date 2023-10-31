package com.framework.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framwork.spring.repository.NewDAO;
import com.framwork.spring.vo.NewVO;

@Controller
public class NewController {
	
	@Autowired // 이 어노테이션은 의존성 주입이라고 생각하면 된다. 즉, 객체를 주입받는다 라는 뜻임.
	private NewDAO newDAO; // new라는 키워드는 없고 변수 사용하듯 생성한다.
	
	
	
	
	@RequestMapping("/junpro")
	public String conn() {
		//NewDAO dao = new NewDAO(); 이제는 new라는 객체를 생성 안한다.
		// 프레임워크안에서 객체를 만드는게 안되는데 따로 객체를 생성하는 코드는 없다.
		ArrayList<NewVO> list = newDAO.newVO();
		
		
		return "WEB-INF/webFile/framwork3.jsp";
	}
}
