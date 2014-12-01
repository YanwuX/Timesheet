package com.mercury.timesheet.daos.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.timesheet.beans.Employee;
import com.mercury.timesheet.daos.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void save(Employee employee) {
		template.save(employee);
	}

	@Override
	public Employee get(String empno) {
		return template.get(Employee.class, empno);
	}

	@Override
	public void update(Employee employee) {
		template.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		template.delete(employee);
	}

}
