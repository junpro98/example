package com.jun.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.jun.spring.service.AService;
import com.jun.spring.vo.DeleteVO;
import com.jun.spring.vo.DetailVO;
import com.jun.spring.vo.LoginVO;
import com.jun.spring.vo.NewVO;

@Controller
public class AController {

	// @Autowired // 이 어노테이션은 의존성 주입이라고 생각하면 된다. 즉, 객체를 주입받는다 라는 뜻임.
	// private ADAO adao; // new라는 키워드는 없고 변수 사용하듯 생성한다.

	@Autowired // service 객체를 주입 받은거임!
	private AService aser;

	@RequestMapping("/select")
	public String conn1(Model jun) { // model은 모델링을 자체적으로 찾아간다.
		// NewDAO dao = new NewDAO(); 이제는 new라는 객체를 생성 안한다.
		// 프레임워크안에서 객체를 만드는게 안되는데 따로 객체를 생성하는 코드는 없다.
		List<NewVO> list = aser.newVO();
		jun.addAttribute("list", list); // setAttribute할때 key값을 주듯 여기도 key값을 준다.
		// list가 넘어간다.

		return "WEB-INF/webFile/framwork.jsp";
	}

	@RequestMapping("/junpro")
	public String conn() {
		// NewDAO dao = new NewDAO(); 이제는 new라는 객체를 생성 안한다.
		// 프레임워크안에서 객체를 만드는게 안되는데 따로 객체를 생성하는 코드는 없다.
//		ArrayList<NewVO> list = newDAO.newVO();

		return "WEB-INF/webFile/framwork2.jsp";
	}

	@RequestMapping("/insert")
	public String conn2() {
		return "WEB-INF/webFile/framwork3.jsp";
	}

	@RequestMapping("/junpro3")
	public String conn3(@ModelAttribute NewVO vo) {
		// 만들어둔 모델링을 스프링에서 알아서 가져와서 사용하는 어노테이션인거다
		// 어노테이션에 들어가는 타입은 오브젝트 타입만 가능하다.
		// jsp파일에서 input name이랑 VO에 만들어둔 거랑 같아야한다. ex) id - id, pw - pw ...
		aser.insert(vo);
		return "/select";
	}

	@RequestMapping("/delete")
	public String dele(@ModelAttribute DeleteVO delVO) {
		aser.delete(delVO);
		return "WEB-INF/webFile/framwork4.jsp";
	}

	@RequestMapping("/check")
	public String check(@ModelAttribute DeleteVO delVO) {
//		System.out.println();
		aser.delete(delVO);
		return "WEB-INF/webFile/show.jsp";
	}

	@RequestMapping("/index")
	public String index() {
		return "WEB-INF/webFile/index.jsp";
	}

	@RequestMapping("/login")
	public String login(@RequestParam String login_id, @RequestParam String login_pw, Model login, HttpSession session) {
		
//		System.out.println(login_id);
//		System.out.println(login_pw);
		List<LoginVO> list = aser.login(login_id, login_pw);
		List<NewVO> list1 = aser.newVO();
		if(list != null && !list.isEmpty()) {
			login.addAttribute("list", list);
			login.addAttribute("list1", list1);
			session.setAttribute("sessionId", login_id);
			session.setAttribute("sessionPw", login_pw);
			return "/WEB-INF/webFile/login.jsp";
		} else {			
			return "/index";
		}
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam String name, Model detail) {
		List<DetailVO> list = aser.detail(name);
		if(name.equals(name)) {
			detail.addAttribute("name", list);
			return "/WEB-INF/webFile/detail.jsp";			
		} 
			return null;
	}
	
	@RequestMapping("/fileup")
	public String fileup(@RequestParam ("file") MultipartFile file, @RequestParam ("id") String id) {
//		String fileRealName = file.getOriginalFilename();
		String realFileName = file.getOriginalFilename();
		long size = file.getSize();
		
		System.out.println("파일이름 : " + realFileName);
		System.out.println("사이즈 : " + size);
		String fileExtension = realFileName.substring(realFileName.lastIndexOf("."),realFileName.length());
		String uploadFolder = "/WEB-INF/file";
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유문자열" + uniqueName);
		System.out.println("확장자명" + fileExtension);
		
		File saveFile = new File(uploadFolder+"\\"+uniqueName + fileExtension);
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		aser.fileup(id, file);
		
		return "/WEB-INF/webFile/test.jsp";
	}
}