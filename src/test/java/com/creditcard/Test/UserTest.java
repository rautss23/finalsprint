package com.creditcard.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.creditcard.entities.User;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.repositories.UserRepository;
import com.creditcard.service.UserService;
@SpringBootTest
class UserTest {

	@Autowired
	UserService userService;
	@MockBean
	UserRepository userReposity;
	User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user = new User();
		user.getVillage();
		user.getCity();
		user.getDob();
		user.getEducation();
		user.getfName();
		user.getGender();
		user.getIncome();
		user.getlName();
		user.getMail();
		user.getPassword();
		user.getPincode();
		user.getUserId();
		user.getUserName();
		user.getPhNumber();
		user.getState();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Mockito.when(userReposity.save(user)).thenReturn(user);
		assertThat(userService.addUser(user));

	}

	@Test
	void testGetMovieShow() throws UserNotFoundException {
		ArrayList showList = new ArrayList();

		Mockito.when(userReposity.findAll()).thenReturn(showList);
		assertThat(userService.getAllUser()).isEqualTo(showList);

	}

}
