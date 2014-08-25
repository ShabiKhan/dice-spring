package com.shabi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.dao.PostJobRequestDAO;
import com.shabi.forms.PostJobDTO;
import com.shabi.forms.UserDTO;

@Controller
@SessionAttributes
public class PostJobController {
	@RequestMapping ("/postJob.page")
	public ModelAndView postJobPage(){
		System.out.println("postJobPage() called from PostJobController");
		return new ModelAndView("/WEB-INF/jsp/postJobPage.jsp","command", new PostJobDTO());
		
	}
	
	@RequestMapping(value = "/postJob.do", method = RequestMethod.POST)
	public ModelAndView postJobDo(@ModelAttribute("job")PostJobDTO job,
									BindingResult result,
									HttpSession session, HttpServletRequest request){
		
		String userId = job.getId();
		System.out.println("userdID received from postJob form is " + userId );
		System.out.println("postJobDo() called from PostJobController");
		PostJobRequestDAO dao = new PostJobRequestDAO();
		dao.postJob(job);
		session.setAttribute("job", job);
				
		System.out.println("Job id Posted in PostJobController " + job.getJobId());
		return new ModelAndView("/WEB-INF/jsp/jobPostedConfirmation.jsp","job",job);
	}	

}
