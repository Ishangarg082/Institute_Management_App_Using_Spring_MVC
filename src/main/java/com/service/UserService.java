package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	public List<User> getAllUsers();

    public void addUser(String username, String pass, String role, String name);

    public void deleteUser(String username);

    public User getUser(String userId);

    public void updateUser(String username, String name, String role, String pass);
}
