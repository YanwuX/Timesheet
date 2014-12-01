package com.mercury.timesheet.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.EmployeeDao;
import com.mercury.timesheet.daos.UserDao;

public class AddAdminTest {
	public static void main(String[] args) {
		ApplicationContext actx = new ClassPathXmlApplicationContext("config.xml");
		UserDao ud = (UserDao)actx.getBean("userDao");
		EmployeeDao ed = (EmployeeDao) actx.getBean("employeeDao");
		PasswordEncoder passwordEncoder = (PasswordEncoder)actx.getBean("passwordEncoder");
		User user = new User();
		user.setAuthority("ROLE_ADMIN");
		user.setEmpno("admin1");
		user.setEnabled(1);
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("mercury"));
		Employee employee = (Employee)ed.get("admin1");
		user.setEmployee(employee);
		ud.save(user);
	}
}
