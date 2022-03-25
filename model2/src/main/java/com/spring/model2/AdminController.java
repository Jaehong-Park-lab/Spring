package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	/**
	 * 제목 : 관리자 메인화면
	 * @return
	 */
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public String mypage() {
		return "/admin/admin";
	}
	
	/**
	 * 제목 : 관리자-공지사항 리스트
	 * @return
	 */
	@RequestMapping(value = "/admin/notice_list", method=RequestMethod.GET)
	public String notice_list() {
		return "/admin/notice/notice_list";
	}
	
	/**
	 * 제목 : 관리자-공지사항 글쓰기
	 * @return
	 */
	@RequestMapping(value = "/admin/notice_write", method=RequestMethod.GET)
	public String notice_write() {
		return "/admin/notice/notice_write";
	}
	
	/**
	 * 제목 : 관리자-공지사항 상세보기
	 * @return
	 */
	@RequestMapping(value = "/admin/notice_content", method=RequestMethod.GET)
	public String notice_content() {
		return "/admin/notice/notice_content";
	}
	
	/**
	 * 제목 : 관리자-공지사항 수정페이
	 * @return
	 */
	@RequestMapping(value = "/admin/notice_update", method=RequestMethod.GET)
	public String notice_update() {
		return "/admin/notice_update";
	}

}
