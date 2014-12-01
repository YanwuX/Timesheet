package com.mercury.timesheet.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mercury.timesheet.beans.Holiday;
import com.mercury.timesheet.daos.HolidayDao;

public class CheckHolidayService {
	private HolidayDao hd;

	public HolidayDao getHd() {
		return hd;
	}
	public void setHd(HolidayDao hd) {
		this.hd = hd;
	}
	
	public boolean checkHoliday(String date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hDate = sdf.parse(date);
		Holiday checkHoliday = hd.get(hDate);
		if(checkHoliday==null) {
			return false;
		}
		else {
			return true;
		}
	}
}
