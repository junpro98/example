package com.jun.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.spring.repository.ADAO;
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
	
	public void delete(String pw, String pk) {
		adao.delete(pw, pk);
		
	}
}
