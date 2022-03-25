package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	/**
	 * 제목 : 게시판 리스트
	 * @return
	 */
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public String board_list() {
		return "/board/board_list";
	}
	
	/**
	 *제목 : 게시판 글쓰기
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write() {
		return "/board/board_write";
	}
	
	/**
	 * 제목 : 게시판 상세보기
	 * @return
	 */
	@RequestMapping(value="/board_content", method=RequestMethod.GET)
	public String board_content() {
		return "/board/board_content";
	}
	
	/**
	 * 제목 : 게시판 수정페이지 화면
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.GET)
	public String board_update() {
		return "/board/board_update";
	}
	
	/**
	 * 제목 : 게시판 삭제페이지
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public String board_delete() {
		return "/board/board_delete";
	}
}
