package com.mercury.timesheet.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.timesheet.beans.Timesheet;
import com.mercury.timesheet.models.RecordInfo;
import com.mercury.timesheet.models.TimesheetInfo;
import com.mercury.timesheet.services.ShowTimesheetService;

@Controller
public class ShowTimesheetController {
	private ShowTimesheetService sts;
	
	public ShowTimesheetService getSts() {
		return sts;
	}
	public void setSts(ShowTimesheetService sts) {
		this.sts = sts;
	}

	@ResponseBody
	@RequestMapping(value="/showRecord", method=RequestMethod.POST)
	public RecordInfo showRecord(HttpServletRequest request, String date) {
		Cookie[] cookies = request.getCookies();
		String empno = null;
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("empno")) {
				empno = cookies[i].getValue();
				break;
			}
		}
		RecordInfo recordInfo = new RecordInfo();
		recordInfo.setWorkDate(date);
		try {
			Timesheet record = sts.searchTimesheet(empno, date);
			if(record==null) {
				return null;
			}
			else {
				recordInfo.setWorkHours(record.getWorkHours());
				recordInfo.setPtoHours(record.getPtoHours());
				recordInfo.setOtHours(record.getOtHours());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordInfo;
	}
	
	@ResponseBody
	@RequestMapping(value="/showTimesheet", method=RequestMethod.POST)
	public TimesheetInfo showTimesheet(HttpServletRequest request, 
				String startDate, String endDate) {
		Cookie[] cookies = request.getCookies();
		String empno = null;
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("empno")) {
				empno = cookies[i].getValue();
				break;
			}
		}
		TimesheetInfo timesheetInfo = new TimesheetInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<Timesheet> records = sts.queryTimesheet(empno, startDate, endDate);
			if(records==null) {
				return null;
			}
			for(Timesheet record:records) {
				Date workDate = record.getWorkDate();
				String stringDate = sdf.format(workDate);
				RecordInfo recordInfo = new RecordInfo();
				recordInfo.setWorkDate(stringDate);
				recordInfo.setWorkHours(record.getWorkHours());
				recordInfo.setPtoHours(record.getPtoHours());
				recordInfo.setOtHours(record.getOtHours());
				timesheetInfo.addRecord(recordInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timesheetInfo;
	}
}
