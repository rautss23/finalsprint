package com.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.exception.NotFoundException;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.entities.User;
import com.creditcard.payload.LoginReq;
import com.creditcard.payload.ValidateUserReq;
import com.creditcard.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/alluser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user1) {
		User user = userService.updateuser(user1);
		if (user == null) {
			return new ResponseEntity("Sorry! User not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/getuser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId) throws UserNotFoundException {
		User user = userService.getUserById(userId);
		if (user == null) {
			return new ResponseEntity("Sorry! User not found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<User> validateUser(@RequestBody LoginReq loginreq) {
		User user1 = userService.validateUser(loginreq.getUserName(), loginreq.getPassword());
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
		Boolean user = userService.deleteUser(userId);
		if (user == false) {
			return new ResponseEntity("User deleted successfully!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("User Id Not found", HttpStatus.OK);
	}

//	-------------------------------------------------------------------
	@PostMapping("/validate")
	public ResponseEntity<String> validateUserMobile(@RequestBody ValidateUserReq validateReq)
			throws NotFoundException {
		boolean result = userService.validateUserPhnumber(validateReq.getPhNumber(), validateReq.getUserName());
		return new ResponseEntity<>("Sucussfully Validated", HttpStatus.OK);
	}

}
