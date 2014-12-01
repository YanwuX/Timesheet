package com.mercury.timesheet.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mercury.timesheet.beans.Holiday;
import com.mercury.timesheet.beans.Timesheet;
import com.mercury.timesheet.beans.User;
import com.mercury.timesheet.daos.HolidayDao;
import com.mercury.timesheet.daos.TimesheetDao;
import com.mercury.timesheet.daos.UserDao;

public class InsertionService {
	private UserDao ud;
	private TimesheetDao td;
	private HolidayDao hd;
	
	public UserDao getUd() {
		return ud;
	}
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	public HolidayDao getHd() {
		return hd;
	}
	public void setHd(HolidayDao hd) {
		this.hd = hd;
	}
	public TimesheetDao getTd() {
		return td;
	}
	public void setTd(TimesheetDao td) {
		this.td = td;
	}

	public void insertRecord(InsertionServiceRequest request) throws Exception {
		String date = request.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date workDate = sdf.parse(date);
		
		Timesheet record = td.get(request.getEmpno(), workDate);
		User user = ud.get(request.getEmpno());
		
		if(record!=null) {
			int recordWorkHours = record.getWorkHours();
			int recordPto = record.getPtoHours();
			int recordOt = record.getOtHours();
			double userRemainPto = user.getRemainPTO();
			int userUsedPto = user.getUsedPTO();
			int userOt = user.getOt();
			user.setOt(userOt-recordOt);
			user.setUsedPTO(userUsedPto-recordPto);
			user.setRemainPTO(userRemainPto+recordPto-((double)recordWorkHours)/24);
			user.removeRecord(record);
		}
		
		Calendar cDate = Calendar.getInstance();
		cDate.setTime(workDate);
		int dayOfWeek = cDate.get(Calendar.DAY_OF_WEEK);
		boolean isWeekend = (dayOfWeek==Calendar.SATURDAY)||(dayOfWeek==Calendar.SUNDAY);
		int workHours = request.getHours();
		Timesheet ts = new Timesheet();
		ts.setWorkDate(workDate);
		ts.setWorkHours(workHours);
		user.addRecord(ts);
		double remainPTO = user.getRemainPTO();
		int ot = user.getOt();
		int usedPTO = user.getUsedPTO();
		user.setRemainPTO(remainPTO + ((double)ts.getWorkHours())/24);
		remainPTO = user.getRemainPTO();
		
		Holiday holiday = hd.get(workDate);
		if(holiday!=null||isWeekend) {
			ts.setPtoHours(0);
			ts.setOtHours(workHours);
			user.setOt(ot + workHours);
		}
		else {
			if(workHours>8) {
				int otHours = workHours - 8;
				ts.setPtoHours(0);
				ts.setOtHours(otHours);
				user.setOt(ot + otHours);
			}
			else if(workHours<8) {
				int lackHours = 8 - workHours;
				ts.setOtHours(0);
				if (remainPTO>=lackHours) {
					ts.setPtoHours(lackHours);
					user.setUsedPTO(usedPTO + lackHours);
					user.setRemainPTO(remainPTO - lackHours);
				}
				else {
					int ptoHours = (int)Math.floor(remainPTO);
					ts.setPtoHours(ptoHours);
					user.setUsedPTO(usedPTO + ptoHours);
					user.setRemainPTO(remainPTO - ptoHours);
				}
			}
		}
		ud.update(user);
	}
}
