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

		// save the user ... finally LOL
		currentSession.saveOrUpdate(user);

	}

	@Override
	public User getUser(long id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the user ... finally LOL
		return currentSession.get(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();

		Query<User> query = session.createQuery("from User", User.class);
		return query.getResultList();

	}

	@Override
	public void deleteUser(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);
		// save the user ... finally LOL
		query.executeUpdate();

	}

}
