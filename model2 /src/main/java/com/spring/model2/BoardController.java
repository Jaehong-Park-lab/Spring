package com.spring.model2;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.BoardDao;
import com.spring.dao.MemberDao;
import com.spring.dto.BoardDto;

@Controller
public class BoardController {
	/**
	 * 제목 : 게시판 리스트
	 * @return
	 */
	@RequestMapping(value="/board_list", method=RequestMethod.GET)
	public ModelAndView board_list() {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.select();
		
		mv.setViewName("/board/board_list");
		mv.addObject("list", list);
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 글쓰기 화면
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.GET)
	public String board_write() {
		return "/board/board_write";
	}
	
	/**
	 * 제목 : 게시판 글쓰기 등록
	 * @return
	 */
	@RequestMapping(value="/board_write", method=RequestMethod.POST)
	public String board_write(BoardDto dto) {
		String result_page = "";
		BoardDao dao = new BoardDao(); 	//DB연동 Dao 객체 생성
		int result = dao.insert(dto);	//Dao에서 insert 메소드 호출하고 결과값(리턴값) 저장
		
		if(result == 1) {
			result_page = "redirect:/board_list";
		}
		
		return result_page;
	}
	
	/**
	 * 제목 : 게시판 상세보기
	 * @return
	 */
	@RequestMapping(value="/board_content", method=RequestMethod.GET)
	public ModelAndView board_content(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		dao.updateHit(bid);
		BoardDto dto = dao.select(bid);

		
		mv.setViewName("/board/board_content");
		mv.addObject("board", dto);
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 수정 화면 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.GET)
	public ModelAndView board_update(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.select(bid);
		
		mv.setViewName("/board/board_update");
		mv.addObject("board", dto);		
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 수정 처리 
	 * @return
	 */
	@RequestMapping(value="/board_update", method=RequestMethod.POST)
	public ModelAndView board_update(BoardDto dto) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		int result = dao.update(dto);
		if(result ==1) {
			mv.setViewName("redirect:/board_list");
		}
			
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 삭제화면 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/board_delete");
		mv.addObject("bid",bid);
		
		return mv;
	}
	
	/**
	 * 제목 : 게시판 삭제 처리 페이지 
	 * @return
	 */
	@RequestMapping(value="/board_delete", method=RequestMethod.POST)
	public ModelAndView board_delete_proc(String bid) {
		ModelAndView mv = new ModelAndView();
		BoardDao dao = new BoardDao();
		int result = dao.delete(bid);	
		
		if(result == 1) {
			mv.setViewName("redirect:/board_list");
		}
		
		return mv;
	}
	
	
}











