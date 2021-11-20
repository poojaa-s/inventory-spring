package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UsersDao;
import com.mph.entity.Users;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao usersDao;
	
	@Override
	public List<Users> getUsersList() {
		// TODO Auto-generated method stub
		return usersDao.getUsersList();
	}


	@Override
	public Users getUsers(Users user) {
		// TODO Auto-generated method stub
	return usersDao.getUsers(user);
	}

	@Override
	public void createUsers(Users user) {
		// TODO Auto-generated method stub
		usersDao.createUsers(user);
	}


	@Override
	public Users getUsersById(int eid) {
		// TODO Auto-generated method stub
		return usersDao.getUsersById(eid);
	}

	

	
}