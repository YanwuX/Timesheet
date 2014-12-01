package com.mercury.timesheet.daos;

import com.mercury.timesheet.beans.Employee;

public interface EmployeeDao {
	public void save(Employee employee);
	public Employee get(String empno);
	public void update(Employee employee);
	public void delete(Employee employee);
}
