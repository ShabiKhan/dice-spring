package com.shabi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shabi.forms.ContactsDTO;

@Controller
@SessionAttributes
public class ContactController {
	

    @RequestMapping("/addContacts.page")// this is action name as in struts
    public ModelAndView addContactPage() {
        System.out.println("addContactPage() called");
        return new ModelAndView("/WEB-INF/jsp/addContactsPage.jsp", "command", new ContactsDTO());
    }	
	
    @RequestMapping(value = "/addContacts.do", method = RequestMethod.POST)
    public ModelAndView addContactDo(@ModelAttribute("contact") ContactsDTO contact, BindingResult result) {
    	System.out.println("result = " + result);
        System.out.println("addContactDo() called");
        System.out.println("First Name:" + contact.getFirstname() +
                    "Last Name:" + contact.getLastname());
         
        return new ModelAndView("/WEB-INF/jsp/addContactsDo.jsp", "contact", contact);
    }
 
}
