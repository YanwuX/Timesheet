package com.mercury.timesheet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.services.CheckHolidayService;

@Controller
public class CheckHolidayController {
	private CheckHolidayService checkHolidayService;

	public CheckHolidayService getCheckHolidayService() {
		return checkHolidayService;
	}
	public void setCheckHolidayService(CheckHolidayService checkHolidayService) {
		this.checkHolidayService = checkHolidayService;
	}
	
	@ResponseBody
	@RequestMapping(value="/isHoliday")
	public String isHoliday(String date) {
		try {
			if(checkHolidayService.checkHoliday(date)) {
				return "yes";
			}
			else {
				return "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}
}
