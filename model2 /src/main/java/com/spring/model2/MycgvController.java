package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MycgvController {
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage() {
		return "/mypage/mycgv";
	}
}
