package com.junpro.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 인터페이스를 통해 다른 클래스에서 사용
public interface sqlExtract1 {
	String sqlData(HttpServletRequest rq, HttpServletResponse rs) throws Exception;
//	인터페이스라는 주머니에 select나 insert, update, delete등을 할 수 있다.
}
