package com.creditcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.entities.User;
import com.creditcard.exception.NotFoundException;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {
		user.setRole("user");
		return userRepo.save(user);
	}

	@Override
	public User updateuser(User user1) {
		return userRepo.save(user1);
	}

	@Override
	public User getUserById(Integer userId) throws UserNotFoundException {
		if (userRepo.existsById(userId)) {
			return userRepo.getById(userId);
		}
		return null;
	}

	@Override
	public boolean deleteUser(Integer userId) {
		userRepo.deleteById(userId);

		User u1 = userRepo.getById(userId);
		if (u1 == null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public User validateUser(String userName, String password) throws UserNotFoundException {

		if (!userRepo.existsByuserName(userName)) {
			throw new UserNotFoundException("User Not Existing");

		}
		Optional<User> result = userRepo.validateUserCredentials(userName, password);
		if (!result.isPresent()) {
			throw new NotFoundException(" invalidation password");

		}

		return result.get();
	}

	@Override
	public boolean validateUserPhnumber(Long pnumber, String userName) throws NotFoundException {
		if (!userRepo.existsByuserName(userName)) {
			throw new UserNotFoundException("User Not Existing");
		}
		Optional<User> result = userRepo.validateUserMobile(pnumber, userName);
		if (!result.isPresent()) {
			throw new NotFoundException("mobile validation failed");

		}

		return true;
	}

}