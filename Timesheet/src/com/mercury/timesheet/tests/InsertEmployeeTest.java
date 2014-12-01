package com.mercury.timesheet.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.daos.EmployeeDao;

public class InsertEmployeeTest {
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDao ed = (EmployeeDao) actx.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setFirstName("Yanwu");
		employee.setLastName("Xu");
		employee.setEmpno("yxu1");
		employee.setConsultantName("Yanwu");
		ed.save(employee);
	}
}
