package com.csseifms.seshat.master.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.csseifms.seshat.master.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer ... finally LOL
		currentSession.save(user);

	}

	@Override
	public void getUser() {

	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();

		Query<User> query = session.createQuery("from User", User.class);
		return query.getResultList();

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub

	}

}
