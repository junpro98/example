package com.framework.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.framwork.spring.repository.ADAO;
import com.framwork.spring.vo.NewVO;

@Controller
public class AController {
	
	@Autowired // 이 어노테이션은 의존성 주입이라고 생각하면 된다. 즉, 객체를 주입받는다 라는 뜻임.
	private ADAO adao; // new라는 키워드는 없고 변수 사용하듯 생성한다.
	
	@RequestMapping("/junpro1")
	public String conn1(Model jun) { // model은 모델링을 자체적으로 찾아간다.
		//NewDAO dao = new NewDAO(); 이제는 new라는 객체를 생성 안한다.
		// 프레임워크안에서 객체를 만드는게 안되는데 따로 객체를 생성하는 코드는 없다.
		ArrayList<NewVO> list = adao.newVO();
		jun.addAttribute("list", list); // setAttribute할때 key값을 주듯 여기도 key값을 준다.
		// list가 넘어간다.
		
		return "WEB-INF/webFile/framwork.jsp";
	}
	
	@RequestMapping("/junpro")
	public String conn() {
		//NewDAO dao = new NewDAO(); 이제는 new라는 객체를 생성 안한다.
		// 프레임워크안에서 객체를 만드는게 안되는데 따로 객체를 생성하는 코드는 없다.
//		ArrayList<NewVO> list = newDAO.newVO();
		
		
		return "WEB-INF/webFile/framwork2.jsp";
	}
	@RequestMapping("/junpro2")
	public String conn2() {
		return "WEB-INF/webFile/framwork3.jsp";
	}
}
