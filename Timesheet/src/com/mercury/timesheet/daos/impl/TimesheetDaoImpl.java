package com.mercury.timesheet.daos.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.timesheet.beans.Timesheet;
import com.mercury.timesheet.daos.TimesheetDao;

public class TimesheetDaoImpl implements TimesheetDao {
	private HibernateTemplate template;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}
	@Override
	public void save(Timesheet ts) {
		template.save(ts);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Timesheet get(String empno, Date date) {
		DetachedCriteria dc = DetachedCriteria.forClass(Timesheet.class);
		dc.add(Restrictions.eq("empno", empno)).add(Restrictions.eq("workDate", date));
		List<Timesheet> records = template.findByCriteria(dc);
		if(records.size()==0) {
			return null;
		}
		return (Timesheet)template.findByCriteria(dc).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> query(String empno, Date start, Date end) {
		DetachedCriteria dc = DetachedCriteria.forClass(Timesheet.class);
		dc.add(Restrictions.eq("empno",empno)).add(Restrictions.between("workDate", start, end));
		return template.findByCriteria(dc);
	}

	@Override
	public void update(Timesheet ts) {
		template.update(ts);
	}

	@Override
	public void saveOrUpdate(Timesheet ts) {
		template.saveOrUpdate(ts);
	}
	
	@Override
	public void delete(Timesheet ts) {
		template.delete(ts);
	}
}
