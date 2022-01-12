package com.csseifms.seshat.master.dao;

import java.util.List;

import com.csseifms.seshat.master.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public void getUser();

	public List<User> getUsers();

	public void updateUser(User user);

	public void deleteUser(Integer id);

}
