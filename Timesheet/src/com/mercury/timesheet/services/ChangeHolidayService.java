package com.mercury.timesheet.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.mercury.timesheet.beans.Holiday;
import com.mercury.timesheet.daos.HolidayDao;

public class ChangeHolidayService {
	private HolidayDao hd;
	
	public HolidayDao getHd() {
		return hd;
	}

	public void setHd(HolidayDao hd) {
		this.hd = hd;
	}

	public void changeHoliday(ChangeHolidayRequest request) throws Exception {
		String date = request.gethDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hDate = sdf.parse(date);
		Holiday holiday = new Holiday();
		holiday.sethDate(hDate);
		Holiday checkHoliday = hd.get(hDate);
		String isHoliday = request.getIsHoliday();
		if(isHoliday.equals("isHoliday")) {
			holiday.sethName(request.gethName());
			hd.saveOrUpdate(holiday);
		}
		else if(isHoliday.equals("notHoliday")){
			if(checkHoliday!=null) {
				hd.delete(holiday);
			}
		}
	}
}
