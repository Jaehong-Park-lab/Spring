package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

@Controller
public class JoinController {
	/** ȸ������ �� **/
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {		
		return "/join/join";
	}
	
	/** ȸ������ ó�� **/
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView join(MemberDto dto) {
		ModelAndView mv = new ModelAndView();
		MemberDao dao = new MemberDao();
		int result = dao.insert(dto);
		String result_page = "";
		
		if(result == 1) {
			result_page = "/login/login";
			mv.setViewName(result_page);
			mv.addObject("result", "ok");
		}
		
		return mv;
	}
}






