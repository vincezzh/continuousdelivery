package com.cd.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value="login", method=RequestMethod.POST)  
    public ModelAndView login(String username, String password){  
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("message", username + " login Successful");
        return mav;
    }
}
