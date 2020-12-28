package com.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.model.User;
import com.utility.HibernateUtility;

public class UserService implements UserDao {

	@Override
	public void registration(User user) {
		try {
			Session session = HibernateUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void login() {
	}

}
