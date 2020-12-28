package com.service;

import com.dao.UserDao;

public class Login implements UserDao {

	@Override
	public boolean login(com.model.Login login) {
		String correctUserName = "Austin";
		String correctPassword = "foo";

		if (login.getUserName().equals(correctUserName) && login.getPassword().equals(correctPassword)) {
			return true;
		} else {
			return false;
		}
	}

}
