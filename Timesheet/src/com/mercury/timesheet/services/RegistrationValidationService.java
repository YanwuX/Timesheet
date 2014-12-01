package com.mercury.timesheet.services;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.EmployeeDao;
import com.mercury.timesheet.daos.UserDao;

public class RegistrationValidationService {
	private EmployeeDao ed;
	private UserDao ud;
	
	public EmployeeDao getEd() {
		return ed;
	}

	public void setEd(EmployeeDao ed) {
		this.ed = ed;
	}

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public String isEmpnoValid(String empno) {
		Employee employee = ed.get(empno);
		if(employee==null) {
			return "no";
		}
		User user = ud.get(empno);
		if(user==null) {
			return "valid";
		}
		else {
			return "exist";
		}
	}
	
	public boolean isUsernameValid(String username) {
		User user = ud.getByUsername(username);
		if(user==null) return true;
		else return false;
	}
}
