package com.mercury.timesheet.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.models.HoursInfo;
import com.mercury.timesheet.services.ShowHoursService;

@Controller
public class ShowHoursController {
	private ShowHoursService shs;

	public ShowHoursService getShs() {
		return shs;
	}
	public void setShs(ShowHoursService shs) {
		this.shs = shs;
	}
	
	@RequestMapping(value="/hoursInfo", method=RequestMethod.POST)
	@ResponseBody
	public HoursInfo showHours(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String empno = null;
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("empno")) {
				empno = cookies[i].getValue();
				break;
			}
		}
		User user = shs.searchUser(empno);
		HoursInfo hoursInfo = new HoursInfo();
		hoursInfo.setRemainPTO(user.getRemainPTO());
		hoursInfo.setUsedPTO(user.getUsedPTO());
		hoursInfo.setOt(user.getOt());
		return hoursInfo;
	}
}
