package com.csseifms.seshat.master.dao;

import java.util.List;

import com.csseifms.seshat.master.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public User getUser(long userId);

	public List<User> getUsers();

	public void deleteUser(long id);

}
