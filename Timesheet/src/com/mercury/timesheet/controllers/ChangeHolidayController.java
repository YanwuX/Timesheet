package com.mercury.timesheet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.services.ChangeHolidayRequest;
import com.mercury.timesheet.services.ChangeHolidayService;

@Controller

public class ChangeHolidayController {
	private ChangeHolidayService chs;

	public ChangeHolidayService getChs() {
		return chs;
	}

	public void setChs(ChangeHolidayService chs) {
		this.chs = chs;
	}
	
	@RequestMapping(value="/changeHoliday")
	@ResponseBody
	public String changeHoliday(@ModelAttribute("changeHolidayRequest") 
		ChangeHolidayRequest changeHolidayRequest) {
		try {
			chs.changeHoliday(changeHolidayRequest);
			return "success";
		} catch (Exception e) {
			return "failure";
		}		
	}
}
