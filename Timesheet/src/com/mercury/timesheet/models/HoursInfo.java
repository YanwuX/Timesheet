package com.mercury.timesheet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HoursInfo {
	private double remainPTO;
	private int usedPTO;
	private int ot;
	
	public double getRemainPTO() {
		return remainPTO;
	}
	@XmlElement(name="remainpto")
	public void setRemainPTO(double remainPTO) {
		this.remainPTO = remainPTO;
	}
	
	public int getUsedPTO() {
		return usedPTO;
	}
	@XmlElement(name="usedpto")
	public void setUsedPTO(int usedPTO) {
		this.usedPTO = usedPTO;
	}
	
	public int getOt() {
		return ot;
	}
	@XmlElement(name="ot")
	public void setOt(int ot) {
		this.ot = ot;
	}
}
