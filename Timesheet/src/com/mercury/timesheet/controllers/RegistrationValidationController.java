package com.mercury.timesheet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.services.RegistrationValidationService;

@Controller
@RequestMapping(value="/validation")
public class RegistrationValidationController {
	private RegistrationValidationService rvs;
	
	public RegistrationValidationService getRvs() {
		return rvs;
	}
	public void setRvs(RegistrationValidationService rvs) {
		this.rvs = rvs;
	}

	@RequestMapping(value="/emp")
	@ResponseBody
	public String validateEmpno(String empno) {
		if("".equals(empno)) {
			return "empty";
		}
		else {
			return rvs.isEmpnoValid(empno);
		}
	}
	
	@RequestMapping(value="/username")
	@ResponseBody
	public String validateUsername(String username) {
		if("".equals(username)) {
			return "empty";
		}
		else if(rvs.isUsernameValid(username)) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
