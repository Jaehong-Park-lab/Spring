package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

@Controller
public class LoginController {
	
	/** login 拳搁 概俏 林家 **/
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
	
	/** login 单捞磐 贸府 **/
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(MemberDto dto) {
		ModelAndView mv = new ModelAndView();
		MemberDao dao = new MemberDao();
		int result = dao.select(dto); 
		
		if(result == 1) {
			mv.setViewName("/main");
			mv.addObject("login_result", "succ");
		}else {
			mv.setViewName("/login/login");
			mv.addObject("login_result", "fail");
		}
		return mv;
	}	
	
	/** login 单捞磐 贸府 **/
	@RequestMapping(value="/login_proc", method=RequestMethod.POST)
	public String login_proc(String id, String pass) {
		System.out.println("id--->" + id);
		System.out.println("pass--->" + pass);
		
		return "/login/login";
	}

}









