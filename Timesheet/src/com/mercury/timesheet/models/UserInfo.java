package com.mercury.timesheet.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo {
	private String fn;
	private String ln;
	private String cn;
	
	public String getFn() {
		return fn;
	}
	@XmlElement
	public void setFn(String fn) {
		this.fn = fn;
	}
	
	public String getLn() {
		return ln;
	}
	@XmlElement
	public void setLn(String ln) {
		this.ln = ln;
	}
	
	public String getCn() {
		return cn;
	}
	@XmlElement
	public void setCn(String cn) {
		this.cn = cn;
	}
	
}
