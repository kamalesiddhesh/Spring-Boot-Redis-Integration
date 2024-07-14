package in.api.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.api.model.User;
import in.api.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/user")
	public String add(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		return service.getUser(userId);
	}
	
	@GetMapping("/users")
	public Collection<User> getAllUsers(){
		return service.getAllUsers();
	}
}
