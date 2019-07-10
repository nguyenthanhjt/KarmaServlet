package com.trungtamjava.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.UserDaoImpl;
import com.trungtamjava.model.User;

public class UserServiceImpl extends JDBCConnection implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void edit(User user) {
		Connection conn = super.getConnection();
		User Olduser = userDao.get(user.getAd());
		if (Olduser != null) {
			Olduser.setAd(user.getAd());
			Olduser.setName(user.getName());
			Olduser.setUsername(user.getUsername());
			Olduser.setPassword(user.getPassword());
			Olduser.setGender(user.getGender());
			Olduser.setCity(user.getCity());
			Olduser.setRole(user.getRole());
			userDao.update(Olduser);
		}
	}

	@Override
	public void delete(int id) {

		userDao.delete(id);
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> listUser(String name) {
		List<User> searchList = new ArrayList<User>();
		searchList = userDao.search(name);
		return searchList;
	}

	@Override
	public User get(String username,String password) {
		User user =userDao.get(username);
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		
		
		return null;
	}

}
