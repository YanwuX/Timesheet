package com.mercury.timesheet.daos;

import java.util.Date;
import java.util.List;

import com.mercury.timesheet.beans.Holiday;

public interface HolidayDao {
	public void save(Holiday holiday);
	public Holiday get(Date date);
	public List<Holiday> query(Date start, Date end);
	public void update(Holiday holiday);
	public void saveOrUpdate(Holiday holiday);
	public void delete(Holiday holiday);
}
