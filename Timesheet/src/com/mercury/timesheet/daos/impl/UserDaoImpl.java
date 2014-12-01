package com.mercury.timesheet.daos.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.UserDao;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(User user) {
		template.save(user);
	}

	@Override
	public User get(String empno) {
		return template.get(User.class, empno);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getByUsername(String username) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("username", username));
		List<User> users = template.findByCriteria(dc);
		if(users.size()==0) {
			return null;
		}
		return users.get(0);
	}

	@Override
	public void update(User user) {
		template.update(user);
	}

	@Override
	public void delete(User user) {
		template.delete(user);
	}
	
}
