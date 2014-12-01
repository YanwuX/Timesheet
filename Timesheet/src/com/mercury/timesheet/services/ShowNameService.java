package com.mercury.timesheet.services;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.daos.EmployeeDao;

public class ShowNameService {
	private EmployeeDao ed;

	public EmployeeDao getEd() {
		return ed;
	}
	public void setEd(EmployeeDao ed) {
		this.ed = ed;
	}
	
	public Employee searchEmployee(String empno) {
		return ed.get(empno);
	}
}
