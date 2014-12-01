package com.mercury.timesheet.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.models.UserInfo;
import com.mercury.timesheet.services.MainService;

@Controller

public class MainController {
	private MainService ms;
	
	public MainService getMs() {
		return ms;
	}
	public void setMs(MainService ms) {
		this.ms = ms;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/main")
	public ModelAndView routerPage(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Authentication authentication 
			= SecurityContextHolder.getContext().getAuthentication();
		List<SimpleGrantedAuthority> authorities 
			= (List<SimpleGrantedAuthority>)authentication.getAuthorities();
		String authority = authorities.get(0).getAuthority();
		if(authority.equals("ROLE_USER")) {
			mav.setViewName("home");
			Object principal = authentication.getPrincipal();
			String username = null;
			if(principal instanceof UserDetails) {
				username = ((UserDetails)principal).getUsername();
			}
			else {
				username = principal.toString();
			}
			Employee employee = ms.searchEmployee(username);
			String empno = employee.getEmpno();
			response.addCookie(new Cookie("empno", empno));
			UserInfo userInfo = new UserInfo();
			userInfo.setFn(employee.getFirstName());
			userInfo.setLn(employee.getLastName());
			userInfo.setCn(employee.getConsultantName());
			mav.addObject("userInfo", userInfo);
		} 
		else if(authority.equals("ROLE_ADMIN")) {
			mav.setViewName("redirect:admin.html");		
		}
		return mav;
	}
}
