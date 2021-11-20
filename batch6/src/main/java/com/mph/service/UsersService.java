package com.mph.service;

import java.util.List;

import com.mph.entity.Users;

public interface UsersService {
	public List<Users> getUsersList();
	public Users getUsers(Users user);
	public void createUsers( Users user);
	public Users getUsersById(int eid);
	
}