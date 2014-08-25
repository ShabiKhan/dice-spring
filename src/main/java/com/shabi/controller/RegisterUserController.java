package com.shabi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.dao.RegisterUserRequestDAO;
import com.shabi.forms.RegisterUserRequestDTO;
import com.shabi.forms.UserDTO;



@Controller
//@SessionAttributes
public class RegisterUserController {
	RegisterUserRequestDAO registerUserRequestDao;
	
	public RegisterUserRequestDAO getRegisterUserDao() {
		return registerUserRequestDao;
	}

	public void setRegisterUserDao(RegisterUserRequestDAO registerUserDao) {
		this.registerUserRequestDao = registerUserDao;
	}

	@RequestMapping("/register.page")
	public ModelAndView showRegisterPage(HttpSession session) {
		System.out.println("registerUser() called from RegisterUserController");
		session.setAttribute("testKey", "TestValue123");
		return new ModelAndView("/WEB-INF/jsp/registerUserPage.jsp","command", new RegisterUserRequestDTO());
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user")RegisterUserRequestDTO user){
		System.out.println("registerUser() called from RegisterUserController");
		
		//RegisterUserRequestDAO registerUserRequestDao = new RegisterUserRequestDAO();
		registerUserRequestDao.registerUser(user);
				
		return new ModelAndView("/WEB-INF/jsp/registerUserDo.jsp","user",user);
		
	}

}
