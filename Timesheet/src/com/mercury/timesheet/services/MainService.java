package com.mercury.timesheet.services;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.UserDao;

public class MainService {
	private UserDao ud;
	
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public Employee searchEmployee(String username) {
		User user = ud.getByUsername(username);
		return user.getEmployee();
	}
}
