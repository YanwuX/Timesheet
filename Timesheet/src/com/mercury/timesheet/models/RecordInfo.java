package com.mercury.timesheet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecordInfo {
	private String workDate;
	private int workHours;
	private int ptoHours;
	private int otHours;
	
	public String getWorkDate() {
		return workDate;
	}
	@XmlElement
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
	public int getWorkHours() {
		return workHours;
	}
	@XmlElement
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	
	public int getPtoHours() {
		return ptoHours;
	}
	@XmlElement
	public void setPtoHours(int ptoHours) {
		this.ptoHours = ptoHours;
	}
	
	public int getOtHours() {
		return otHours;
	}
	@XmlElement
	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}
}
