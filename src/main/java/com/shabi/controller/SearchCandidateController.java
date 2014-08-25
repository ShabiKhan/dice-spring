package com.shabi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.dao.SearchCandidateDAO;
import com.shabi.forms.ContactsDTO;
import com.shabi.forms.SearchCandidateDTO;
import com.shabi.forms.SearchCandidateRequestDTO;


@Controller
@SessionAttributes
public class SearchCandidateController {
	@RequestMapping("/searchCandidate.page")
	public ModelAndView searchCandidatePage() {
		System.out.println("searchCandidatePage() called from SearchCandidateController");
		return new ModelAndView("/WEB-INF/jsp/searchCandidatePage.jsp","command", new SearchCandidateRequestDTO());
	}
	
	@RequestMapping(value = "/searchCandidate.do", method = RequestMethod.POST)
	public ModelAndView searchCandidateDo(@ModelAttribute("skills") SearchCandidateRequestDTO skills, 
											BindingResult result,
											HttpServletRequest request ) {
		System.out.println("result = " + result);
		System.out.println("skills = " + skills.getSkills());
		String skill = skills.getSkills();
		
		SearchCandidateDAO canDAO = new SearchCandidateDAO ();
		
		
		List<SearchCandidateDTO> candidates = canDAO.searchCandidate(skill);
		request.setAttribute("candidates", candidates);	
		return new ModelAndView("/WEB-INF/jsp/searchedCandidateList.jsp", "candidates", candidates);
	}	
}
