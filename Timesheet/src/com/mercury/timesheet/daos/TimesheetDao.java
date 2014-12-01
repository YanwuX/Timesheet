package com.mercury.timesheet.daos;

import java.util.Date;
import java.util.List;

import com.mercury.timesheet.beans.Timesheet;

public interface TimesheetDao {
	public void save(Timesheet ts);
	public Timesheet get(String empno, Date date);
	public List<Timesheet> query(String empno, Date start, Date end);
	public void update(Timesheet ts);
	public void saveOrUpdate(Timesheet ts);
	public void delete(Timesheet ts);
}
