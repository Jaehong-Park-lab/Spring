package com.spring.model2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/** login 화면 매핑 주소 **/
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public String login() {
		return "/login/login"; //login폴더에서 login.jsp를 찾아
	}
}
