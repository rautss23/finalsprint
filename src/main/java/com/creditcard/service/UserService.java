package com.creditcard.service;

import java.util.List;

import com.creditcard.entities.User;
import com.creditcard.exception.NotFoundException;
import com.creditcard.exception.UserNotFoundException;

public interface UserService {

	public User addUser(User user);

	public User getUserById(Integer userId) throws UserNotFoundException;

	public User updateuser(User user1);

	public boolean deleteUser(Integer userId);

	public List<User> getAllUser();

	public User validateUser(String userName, String password) throws UserNotFoundException;

	boolean validateUserPhnumber(Long pnumber, String userName) throws NotFoundException;

}
