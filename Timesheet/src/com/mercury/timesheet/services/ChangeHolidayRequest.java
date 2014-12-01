package com.mercury.timesheet.services;

public class ChangeHolidayRequest {
	private String isHoliday;
	private String hName;
	private String hDate;
	
	public String getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(String isHoliday) {
		this.isHoliday = isHoliday;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethDate() {
		return hDate;
	}
	public void sethDate(String hDate) {
		this.hDate = hDate;
	}
	
	public ChangeHolidayRequest(){}
	public ChangeHolidayRequest(String isHoliday, String hName, String hDate) {
		this.isHoliday = isHoliday;
		this.hName = hName;
		this.hDate = hDate;
	}
}
