package com.mercury.timesheet.beans;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Holiday {
	private Date hDate;
	private String hName;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column
	public Date gethDate() {
		return hDate;
	}
	public void sethDate(Date hDate) {
		this.hDate = hDate;
	}
	
	@Column
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	
}
