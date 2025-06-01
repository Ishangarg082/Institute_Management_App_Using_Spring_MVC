package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;

@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserDao userdao;

    public List<User> getAllUsers() {
        return userdao.getusers();
    }

    public void addUser(String username, String pass, String role, String name) {
    	User user = new User();
    	user.setName(name);
    	user.setPass(pass);
    	user.setRole(role);
    	user.setUser_id(username);
        userdao.add(user);
    }

    public void deleteUser(String username) {
        userdao.remove(username);
    }

    public User getUser(String userId) {
        return userdao.get(userId);
    }

    public void updateUser(String username, String name, String role, String pass) {
    	User user = userdao.get(username);
    	if (user != null) {
    	    user.setName(name);
    	    user.setRole(role);
    	    user.setPass(pass);
    	    userdao.update(user);
    	}
    }
}
