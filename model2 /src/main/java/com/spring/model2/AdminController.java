package com.spring.model2;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

@Controller
public class AdminController {
	
	/**
	 * ���� : ȸ�� ����Ʈ ������
	 * @return
	 */
	@RequestMapping(value="/admin/member_list", method=RequestMethod.GET)
	public ModelAndView member_list() {
		ModelAndView mv = new ModelAndView();
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> list = dao.select();
		
		mv.setViewName("/admin/member/member_list");
		mv.addObject("list", list);
				
		return mv;
	}
	
	/**
	 * ���� : ������ ����ȭ��
	 * @return
	 */
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		return "/admin/admin";
	}
	
	/**
	 * ���� : ������-�������� ����Ʈ
	 * @return
	 */
	@RequestMapping(value="/admin/notice_list", method=RequestMethod.GET)
	public String notice_list() {
		return "/admin/notice/notice_list";
	}
	
	/**
	 * ���� : ������-�������� �۾���
	 * @return
	 */
	@RequestMapping(value="/admin/notice_write", method=RequestMethod.GET)
	public String notice_write() {
		return "/admin/notice/notice_write";
	}
	
	/**
	 * ���� : ������-�������� �󼼺���
	 * @return
	 */
	@RequestMapping(value="/admin/notice_content", method=RequestMethod.GET)
	public String notice_content() {
		return "/admin/notice/notice_content";
	}
	
	/**
	 * ���� : ������-�������� ����������
	 * @return
	 */
	@RequestMapping(value="/admin/notice_update", method=RequestMethod.GET)
	public String notice_update() {
		return "/admin/notice/notice_update";
	}
	
	/**
	 * ���� : ������-�������� ����������
	 * @return
	 */
	@RequestMapping(value="/admin/notice_delete", method=RequestMethod.GET)
	public String notice_delete() {
		return "/admin/notice/notice_delete";
	}
}
