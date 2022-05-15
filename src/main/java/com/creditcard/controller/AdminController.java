package com.creditcard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditcard.entities.Admin;
import com.creditcard.payload.LoginReq;
import com.creditcard.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}

	@GetMapping("/alladmin")

	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@PostMapping("/login")
	public ResponseEntity<Admin> validateAdmin(@RequestBody LoginReq loginreq) {

		Admin admin1 = adminService.validateAdmin(loginreq.getUserName(), loginreq.getPassword());

		return new ResponseEntity<Admin>(admin1, HttpStatus.OK);
	}

}
