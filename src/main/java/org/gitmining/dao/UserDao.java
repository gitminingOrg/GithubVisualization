package org.gitmining.dao;

import java.util.List;

import org.gitmining.bean.User;
import org.gitmining.bean.UserScore;

public interface UserDao {
	public List<User> selectAllUsers();
	public int countUsers();
	public User selectUserById(int id);
	public User selectUserByName(String login);
	public UserScore selectUserScoreById(int id);
	public List<User> selectTOP20Users();
}
