package com.csseifms.seshat.master.service;

import java.util.List;

import com.csseifms.seshat.master.model.User;

public interface UserService {

	List<User> getUsers();

	void saveUser(User user);

	User getUser(long theId);

	void delete(long theId);

}
