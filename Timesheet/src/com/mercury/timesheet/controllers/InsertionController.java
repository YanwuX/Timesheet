package com.mercury.timesheet.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.services.InsertionService;
import com.mercury.timesheet.services.InsertionServiceRequest;

@Controller

public class InsertionController {
	private InsertionService is;
	
	public InsertionService getIs() {
		return is;
	}
	public void setIs(InsertionService is) {
		this.is = is;
	}

	@ModelAttribute("insertionServiceRequest")
	public InsertionServiceRequest createRequest() {
		InsertionServiceRequest request = new InsertionServiceRequest();
		request.setEmpno(null);
		return request;
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(HttpServletRequest request, 
			@ModelAttribute("insertionServiceRequest") 
			InsertionServiceRequest insertionServiceRequest) {
		Cookie[] cookies = request.getCookies();
		String empno = null;
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("empno")) {
				empno = cookies[i].getValue();
				break;
			}
		}
		insertionServiceRequest.setEmpno(empno);
		try {
			is.insertRecord(insertionServiceRequest);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
}
