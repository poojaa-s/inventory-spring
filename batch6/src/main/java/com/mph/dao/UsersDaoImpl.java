package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Users> getUsersList() {
		Query qry = getSession().createQuery("from Users");
		List<Users> usersList = qry.list();
		return usersList;
	}



	@Override
	public Users getUsers(Users user) {
		// TODO Auto-generated method stub
		Criteria c = getSession().createCriteria(Users.class);
		c.add(Restrictions.eq("userName", user.getUserName()));
		Users user1= (Users)c.uniqueResult();		
		return user1;
	}

	@Override
	public void createUsers(Users user) {
		getSession().saveOrUpdate(user);
		System.out.println("Registerd Successfully :)");
		System.out.println("User->"+user);
	}

	@Override
	public Users getUsersById(int eid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Users user where userId=:eno");
		query.setParameter("eno", eid);
		Users userlist =(Users) query.uniqueResult();
		System.out.println(userlist);
		return userlist; 
	}




     
			 
       
}