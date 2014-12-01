package com.mercury.timesheet.services;

import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.UserDao;

public class ShowHoursService {
	private UserDao ud;
	
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User searchUser(String empno) {
		return ud.get(empno);
	}
}
