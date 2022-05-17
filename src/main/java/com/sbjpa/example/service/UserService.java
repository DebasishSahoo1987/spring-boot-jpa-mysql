package com.sbjpa.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbjpa.example.exceptions.DatabaseException;
import com.sbjpa.example.exceptions.UserNotFound;
import com.sbjpa.example.model.User;
import com.sbjpa.example.model.UserInfo;
import com.sbjpa.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User save(User user) {
		User u= userRepository.save(user);
		return u;
		
	}
	
	public List<User> saveAllUsers(List<User> users){
		List<User> userList=null;
		userList=userRepository.saveAll(users);
		return userList;
	}
	
	public List<User> getUsers(){
		
		List<User> userList=null;
		userList=userRepository.findAll();
		return userList;
	}
	
	public User getUserById(Integer id) throws UserNotFound,DatabaseException{
		
		if(id==null)
			throw new UserNotFound("User with ID="+id +"not allowed");
		//try {
		Optional<User> user=userRepository.findById(id);
		if(user.isPresent())
			return user.get();
		else 
			throw new UserNotFound("User not available with Id = " +id);
	
//		}
//		catch(Exception e) {
//			throw new DatabaseException("Internal Server Error...Please try after some time...");
//		}
	}
	
	public List<User> getUserByUserName(String name) {
		List<User> user=null;
		user=userRepository.findByuserName(name).orElse(null);
		return user;
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		
	}
	
	public List<User> getTopPaidUsers(){
		List<User> users=null;
		users=userRepository.findAllTopPaidUsers().orElseThrow();
		return users;
	}
	
	public List<UserInfo> getSelectedFieldsOfUserByName(String name){	
		List<UserInfo> userinfo=null;
		userinfo=userRepository.findSelectedFieldsForUser(name).orElseThrow();
		return userinfo;
	}
	
	public List<Object[]> getSelectedFieldsOfUserByName1(String name){	
		List<Object[]> userinfo=null;
		userinfo=userRepository.findSelectedFieldsForUser1(name).orElseThrow();
		return userinfo;
	}
}
	
