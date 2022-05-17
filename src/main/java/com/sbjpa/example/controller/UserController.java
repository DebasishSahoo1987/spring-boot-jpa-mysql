package com.sbjpa.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbjpa.example.exceptions.DatabaseException;
import com.sbjpa.example.exceptions.UserNotFound;
import com.sbjpa.example.model.User;
import com.sbjpa.example.model.UserInfo;
import com.sbjpa.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Value("${server.port}")
	String port;
	
	@GetMapping("/server")
	public String getTomcatServer(){
		
		return port;
	}
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		//return userService.save(user);
		User rtnValue=userService.save(user);
		return new ResponseEntity<User>(rtnValue,HttpStatus.CREATED);
	}
	
	@PostMapping("/saveusers")
	public List<User> createUsers(@RequestBody List<User> users) {
		return userService.saveAllUsers(users);
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/getUsers/{id}")
	public User getUserById(@PathVariable int id) throws UserNotFound, DatabaseException {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUsersByName/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return userService.getUserByUserName(name);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestBody User user) {
		 userService.deleteUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable int id) {
		 userService.deleteUserById(id);
	}
	
	@GetMapping("/topPaidUsers")
	public List<User> getTopPaidUsers() {
		return userService.getTopPaidUsers();
	}
	
	@GetMapping("/getSelectedFieldsOfUserByName/{name1}")
	public List<UserInfo> getSelectedFieldsOfUserByName(@PathVariable(value = "name1") String name) {
		return userService.getSelectedFieldsOfUserByName(name);
	}
	
	@GetMapping("/getSelectedFieldsOfUserByName1/{name1}")
	public List<Object[]> getSelectedFieldsOfUserByName1(@PathVariable(value = "name1") String name) {
		return userService.getSelectedFieldsOfUserByName1(name);
	}
}
