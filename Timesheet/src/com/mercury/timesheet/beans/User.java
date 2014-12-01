package com.mercury.timesheet.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="users")
public class User {
	private String empno;
	private String username;
	private String password;
	private int usedPTO;
	private double remainPTO;
	private int ot;
	private String authority;
	private int enabled;
	private Employee employee;
	private Set<Timesheet> records;
	
	@GenericGenerator(name="generator", strategy="foreign",
			parameters=@Parameter(name="property", value="employee"))
	@Id
	@GeneratedValue(generator="generator")
	@Column
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	@Column
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	public int getUsedPTO() {
		return usedPTO;
	}
	public void setUsedPTO(int usedPTO) {
		this.usedPTO = usedPTO;
	}
	
	@Column
	public double getRemainPTO() {
		return remainPTO;
	}
	public void setRemainPTO(double remainPTO) {
		this.remainPTO = remainPTO;
	}
	
	@Column
	public int getOt() {
		return ot;
	}
	public void setOt(int ot) {
		this.ot = ot;
	}

	@Column
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="empno")
	@Cascade({CascadeType.ALL})
	public Set<Timesheet> getRecords() {
		return records;
	}
	public void setRecords(Set<Timesheet> records) {
		this.records = records;
	}
	
	public void addRecord(Timesheet record) {
		records.add(record);
		record.setEmpno(empno);
	}
	public void removeRecord(Timesheet record) {
		records.remove(record);
	}
	
	public User() {
		this.records = new HashSet<Timesheet>();
	}
}
