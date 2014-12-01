package com.mercury.timesheet.services;

public class InsertionServiceRequest {
	private String empno;
	private String date;
	private int hours;
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public InsertionServiceRequest(){}
	public InsertionServiceRequest(String date, int hours) {
		this.date = date;
		this.hours = hours;
	}
	public InsertionServiceRequest(String empno, String date, int hours) {
		this.empno = empno;
		this.date = date;
		this.hours = hours;
	}
}
