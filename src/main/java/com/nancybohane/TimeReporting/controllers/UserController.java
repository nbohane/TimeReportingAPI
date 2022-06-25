package com.nancybohane.TimeReporting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nancybohane.TimeReporting.models.User;
import com.nancybohane.TimeReporting.repositories.UserRepository;

@Controller
@CrossOrigin
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//Create
	@PostMapping(path = "")
	public @ResponseBody User createUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
	//Read all
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//Read by ID
	@GetMapping(path = "")
	public @ResponseBody User getUserById(@RequestParam int id) {
		return userRepository.findById(id).get();
	}
	
	//Update
	@PutMapping(path = "")
	public @ResponseBody String updateUser(@RequestBody User user) {
		userRepository.save(user);
		return "User Updated Successfully!";
	}
	
	@PutMapping(path = "/changepassword")
	public @ResponseBody String updatePassword(@RequestBody User user) {
		User dbUser = userRepository.findById(user.getId()).get();
		dbUser.setPassword(user.getPassword());
		userRepository.save(user);
		return "Password Updated Successfully!";
	}
	
	
	//Delete
	@DeleteMapping(path = "")
	public @ResponseBody String deleteUser(@RequestParam int id) throws Exception {
		try {
			userRepository.deleteById(id);
			return "Deleted user with : " + id + " id!";
		}catch(Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Could not delete user with id: " + id);
	}
	
	
}
