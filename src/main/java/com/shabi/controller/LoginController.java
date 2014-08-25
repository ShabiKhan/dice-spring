package com.shabi.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.dao.UserDAO;
import com.shabi.forms.LoginRequestDTO;
import com.shabi.forms.UserDTO;

@Controller
//@Scope("session")
public class LoginController {
	
	private UserDAO userDao;
			
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	@RequestMapping("/login.page")
	public ModelAndView showLoginPage(){
		System.out.println("showLoginPage() called");
		return new ModelAndView("/WEB-INF/jsp/loginPage.jsp","command", new LoginRequestDTO());
	}
	@ModelAttribute("requestUserDto")
    public LoginRequestDTO getLoginForm() {
        return new LoginRequestDTO();
    }

	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView loginDo(@ModelAttribute("requestUserDto")@Value(value = "requestUserDto") LoginRequestDTO requestUserDto, 
								BindingResult result,
								HttpSession session) {
		
		System.out.println("Data receievd from form is email = " + requestUserDto.getEmail()
				+ " /and password = " + requestUserDto.getPassword());
		String email = requestUserDto.getEmail();
		String password = requestUserDto.getPassword();
		//UserDAO userDao = new UserDAO();
		
		System.out.println("loginDo() called");
		if (result.hasErrors()) {             //this means user does not exist, do vaidation here
			return new ModelAndView("/WEB-INF/jsp/loginPage.jsp");
		} 
		else {
			if (userDao.authenticateUser(email, password)) {       //means if true
				UserDTO user = userDao.getUserProfile();
				session.setAttribute("user", user);
				return new ModelAndView("/WEB-INF/jsp/homePage.jsp");
			}
			else {
				return new ModelAndView("/WEB-INF/jsp/loginPage.jsp");
			}
		}
	}	
}
/*
 * adding some comments 
 */