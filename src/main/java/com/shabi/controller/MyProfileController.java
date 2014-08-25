package com.shabi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyProfileController {

	@RequestMapping("/myProfile.page")
	public ModelAndView showUserProfile() {
		System.out.println("showUserProfile() called from MyProfileController");
		return new ModelAndView("/WEB-INF/jsp/myProfileDo.jsp");
	}
}
