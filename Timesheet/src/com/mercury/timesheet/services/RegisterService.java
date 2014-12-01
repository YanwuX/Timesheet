package com.mercury.timesheet.services;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.EmployeeDao;
import com.mercury.timesheet.daos.UserDao;

public class RegisterService {
	private PasswordEncoder passwordEncoder;
	private UserDao ud;
	private EmployeeDao ed;
	
	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public EmployeeDao getEd() {
		return ed;
	}

	public void setEd(EmployeeDao ed) {
		this.ed = ed;
	}

	public void saveUser(RegisterServiceRequest request) {
		String empno = request.getEmpno();
		Employee employee = ed.get(empno);
		User user = new User();
		user.setEmpno(empno);
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setUsedPTO(0);
		user.setRemainPTO(0);
		user.setOt(0);
		user.setAuthority("ROLE_USER");
		user.setEnabled(1);
		user.setEmployee(employee);
		employee.setUser(user);
		ud.save(user);
	}
}
