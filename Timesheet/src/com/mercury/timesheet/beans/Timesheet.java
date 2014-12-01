package com.mercury.timesheet.beans;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Timesheet {
	private int id;
	private String empno;
	private Date workDate;
	private int workHours;
	private int ptoHours;
	private int otHours;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	@Column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JoinColumn(name="empno")
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	@Column
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	
	@Column
	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	
	@Column
	public int getPtoHours() {
		return ptoHours;
	}
	public void setPtoHours(int ptoHours) {
		this.ptoHours = ptoHours;
	}
	
	@Column
	public int getOtHours() {
		return otHours;
	}
	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}
	
	
}
