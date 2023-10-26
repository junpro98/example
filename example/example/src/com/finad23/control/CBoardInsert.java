package com.finad23.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finad23.DTO.CompanyBoardDTO;
import com.finad23.mybatis.SqlInsert;

public class CBoardInsert implements ConInter {
	static CBoardInsert cboardInsert = new CBoardInsert();
	public static CBoardInsert instance() {
		return cboardInsert;
	}
	
	@Override
	public String FinAD(HttpServletRequest rq, HttpServletResponse rs) throws Exception {
		System.out.println("test1");
		String title = rq.getParameter("title");
		String companyName = rq.getParameter("companyName");
		String companyInfo1 = rq.getParameter("companyInfo1");
		String companyInfo2 = rq.getParameter("companyInfo2");
		String companyInfo3 = rq.getParameter("companyInfo3");
		String recruitmentDate1 = rq.getParameter("recruitmentDate1");
		String recruitmentDate2 = rq.getParameter("recruitmentDate2");
		String promotionDate1 = rq.getParameter("promotionDate1");
		String promotionDate2 = rq.getParameter("promotionDate2");
		String recruitmentNum = rq.getParameter("recruitmentNum");
		String sex = rq.getParameter("sex");
		int avgViewers = Integer.parseInt(rq.getParameter("avgViewers"));
		int subscribers = Integer.parseInt(rq.getParameter("subscribers"));
		String  underachiever = rq.getParameter("underachiever");
		int promotionMoney = Integer.parseInt(rq.getParameter("promotionMoney"));
		String promotionType = rq.getParameter("promotionType");
		String previousPromotion1 = rq.getParameter("previousPromotion1");
		String previousPromotion2 = rq.getParameter("previousPromotion2");
		String previousPromotion3 = rq.getParameter("previousPromotion3");
		String text = rq.getParameter("text");
		
		CompanyBoardDTO CBoardDTO = new CompanyBoardDTO();
		CBoardDTO.setTitle(title);
		CBoardDTO.setCompanyName(companyName);
		CBoardDTO.setCompanyInfo1(companyInfo1);
		CBoardDTO.setCompanyInfo2(companyInfo2);
		CBoardDTO.setCompanyInfo3(companyInfo3);
		CBoardDTO.setRecruitmentDate1(recruitmentDate1);
		CBoardDTO.setRecruitmentDate2(recruitmentDate2);
		CBoardDTO.setPromotionDate1(promotionDate1);
		CBoardDTO.setPromotionDate2(promotionDate2);
		CBoardDTO.setRecruitmentNum(recruitmentNum);
		CBoardDTO.setAvgViewers(avgViewers);
		CBoardDTO.setSubscribers(subscribers);
		CBoardDTO.setSex(sex);
		CBoardDTO.setUnderachiever(underachiever);
		CBoardDTO.setPromotionMoney(promotionMoney);
		CBoardDTO.setPromotionType(promotionType);
		CBoardDTO.setPreviousPromotion1(previousPromotion1);
		CBoardDTO.setPreviousPromotion2(previousPromotion2);
		CBoardDTO.setPreviousPromotion3(previousPromotion3);
		CBoardDTO.setText(text);
		
		System.out.println("test2");
		SqlInsert insert = SqlInsert.instance();
		insert.sqlInsert(CBoardDTO);
		
		System.out.println("test4");

		return null;
}
}
