package com.mercury.timesheet.daos;

import com.mercury.timesheet.beans.User;

public interface UserDao {
	public void save(User user);
	public User get(String empno);
	public User getByUsername(String username);
	public void update(User user);
	public void delete(User user);
}
