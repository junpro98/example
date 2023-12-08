package com.jun.spring.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.jun.spring.repository.ADAO;
import com.jun.spring.vo.DeleteVO;
import com.jun.spring.vo.DetailVO;
import com.jun.spring.vo.LoginVO;
import com.jun.spring.vo.NewVO;

@Service
public class AService { // 데이터 연결해서 처리하는 작업 클래스
	// 그럼 여기에 db처리하는 문장이 이씅면 된다.
	// dao에 db처리하는걸 여기서 부르면 된다.
	
	@Autowired
	private ADAO adao;
	
	public List<NewVO> newVO() {
		List<NewVO> list = adao.newVO();
		return list;
	}
	
	public void insert(NewVO vo) {
		adao.insert(vo);
	}
	
	public void delete(DeleteVO delVO) {
		adao.delete(delVO);
		
	}
	public List<LoginVO> login(String login_id, String login_pw) {
	    List<LoginVO> list = adao.login(login_id, login_pw);
//	    System.out.println(login_id);
//	    System.out.println(login_pw);
		return list;
	}
	public List<DetailVO> detail(String name) {
		List<DetailVO> list = adao.detail(name);
		return list;
	}
	public void fileup(String id, MultipartFile file) {
		adao.fileup(id, file);
	}
}
