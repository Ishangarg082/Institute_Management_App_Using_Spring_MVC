package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {
	public List<User> getusers();
	public User get(String userid);
	public void add(User user);
	public void remove(String userid);
	public void update(User user);
}
