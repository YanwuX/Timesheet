package com.mercury.timesheet.services;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.mercury.timesheet.beans.Timesheet;
import com.mercury.timesheet.daos.TimesheetDao;

public class ShowTimesheetService {
	private TimesheetDao td;
	
	public TimesheetDao getTd() {
		return td;
	}
	public void setTd(TimesheetDao td) {
		this.td = td;
	}

	public Timesheet searchTimesheet(String empno, String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date searchDate = sdf.parse(date);
		return td.get(empno, searchDate);
	}
	
	public List<Timesheet> queryTimesheet(String empno, String start, String end) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		List<Timesheet> records = td.query(empno, startDate, endDate);
		if(records.size()==0) {
			return null;
		}
		Collections.sort(records, new Comparator<Timesheet>() {
			@Override
			public int compare(Timesheet a, Timesheet b) {
				return a.getWorkDate().compareTo(b.getWorkDate());
			}
		});
		return records;
	}
}
