package com.cd.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cd.view.controller.vo.UserVO;
import com.cd.view.maker.VOMaker;
import com.vince.cd.service.LoginService;

@Controller
public class LoginController {
	@Autowired  
	@Qualifier("loginService")
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value="login", method=RequestMethod.POST)  
    public ModelAndView login(UserVO user) throws Exception {
		UserVO finalUser = VOMaker.populateVO(loginService.login(VOMaker.populateModel(user)));
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("message", finalUser.getUsername() + " login Successful");
        return mav;
    }
}
