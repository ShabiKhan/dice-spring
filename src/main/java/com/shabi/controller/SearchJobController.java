package com.shabi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.dao.SearchJobDAO;
import com.shabi.forms.SearchJobRequestDTO;
import com.shabi.forms.SearchJobResponseDTO;

@Controller
@SessionAttributes
public class SearchJobController {
	private SearchJobDAO searchJobDao;	
	
	public SearchJobDAO getSearchJobDao() {
		return searchJobDao;
	}

	public void setSearchJobDao(SearchJobDAO searchJobDao) {
		this.searchJobDao = searchJobDao;
	}

	@RequestMapping(value = "/searchJob.page")
	public ModelAndView searchJobPage(){
		System.out.println("searchJobPage() called");
		return new ModelAndView("/WEB-INF/jsp/searchJobPage.jsp","command", new SearchJobRequestDTO());
		
	}
	
	@RequestMapping(value = "/searchJob.do", method = RequestMethod.POST)
	public ModelAndView searchJob(@ModelAttribute("job")SearchJobRequestDTO job, 
												BindingResult result,
												HttpServletRequest request
												){
		System.out.println("searchJob() called from SearchJobController");
		System.out.println("jobs skills = " + job.getSkills()+
				"id = "+ job.getUserId());
		String skills = job.getSkills();
		int userId = job.getUserId();
		//SearchJobDAO searchDAO = new SearchJobDAO();
		System.out.println("searchJobDao :****** " + searchJobDao + "**********");
		List<SearchJobResponseDTO> jobs = searchJobDao.getJobs(skills, userId);
		request.setAttribute("jobs", jobs);

		return new ModelAndView("/WEB-INF/jsp/searchedJobList.jsp","jobs",jobs);
	}	

}
