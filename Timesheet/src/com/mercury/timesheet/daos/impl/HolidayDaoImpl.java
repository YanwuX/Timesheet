package com.mercury.timesheet.daos.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.timesheet.beans.Holiday;
import com.mercury.timesheet.daos.HolidayDao;

public class HolidayDaoImpl implements HolidayDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(Holiday holiday) {
		template.save(holiday);
	}

	@Override
	public Holiday get(Date date) {
		return template.get(Holiday.class, date);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Holiday> query(Date start, Date end) {
		DetachedCriteria dc = DetachedCriteria.forClass(Holiday.class);
		dc.add(Restrictions.between("hDate", start, end));
		return template.findByCriteria(dc);
	}

	@Override
	public void update(Holiday holiday) {
		template.update(holiday);
	}
	
	@Override
	public void saveOrUpdate(Holiday holiday) {
		template.saveOrUpdate(holiday);		
	}

	@Override
	public void delete(Holiday holiday) {
		template.delete(holiday);
	}
	
}
