package com.mercury.timesheet.services;

public class RegisterServiceRequest {
	private String empno;
	private String username;
	private String password;
	private String email;
	
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public RegisterServiceRequest(){}
	public RegisterServiceRequest(String empno, String username, String password, String email) {
		this.empno = empno;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
