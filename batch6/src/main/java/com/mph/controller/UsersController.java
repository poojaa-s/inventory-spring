package com.mph.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Users;
import com.mph.service.UsersService;



@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "http://localhost:4200",
methods = {RequestMethod.GET,RequestMethod.POST},
allowCredentials = "false",allowedHeaders = "*")
public class UsersController {

	
	
	@Autowired
	UsersService usersService;
	
	private static final Logger logger = Logger.getLogger("UsersRestController.class");
	
	@GetMapping("/allusers")
	public ResponseEntity<List<Users>> allUsers()
	{
		logger.info("GETTING HTTP REQUEST FROM ANGULAR APPLICATION TO LIST USERS");
		System.out.println(logger.getName()+  "   " + logger.getLevel());
		
		PropertyConfigurator.configure(UsersController.class.getClassLoader().getResource("log4j.properties"));
		System.out.println("Logger config is successfull");
		List<Users> ulist=usersService.getUsersList();
		System.out.println(ulist);
		if(ulist.isEmpty())
		{
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(ulist,HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/createUsers")
	public Users createUsers(@RequestBody Users users)
	{
		usersService.createUsers(users);
		return users;
	}
	
	
	@GetMapping("/getUsers/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable("id") int eid)
	{
		Users user= usersService.getUsersById(eid);
		if(user == null)
		{
			return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	
}