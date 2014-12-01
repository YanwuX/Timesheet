package com.mercury.timesheet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.timesheet.services.MailService;
import com.mercury.timesheet.services.RegisterService;
import com.mercury.timesheet.services.RegisterServiceRequest;

@Controller
public class RegisterController {
	private RegisterService rs;
	private MailService ms;
	
	public RegisterService getRs() {
		return rs;
	}

	public void setRs(RegisterService rs) {
		this.rs = rs;
	}

	public MailService getMs() {
		return ms;
	}

	public void setMs(MailService ms) {
		this.ms = ms;
	}

	@RequestMapping(value="/registered", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerServiceRequest") 
		RegisterServiceRequest registerServiceRequest) {
		rs.saveUser(registerServiceRequest);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registered");
		mav.addObject("msg", "Registration Succeed!");
		ms.sendMail(registerServiceRequest);
		return mav;
	}
}
