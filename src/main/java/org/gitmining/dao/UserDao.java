package org.gitmining.dao;

import java.util.List;

import org.gitmining.bean.User;

public interface UserDao {
	public List<User> selectAllUsers();
	public int countUsers();
}
