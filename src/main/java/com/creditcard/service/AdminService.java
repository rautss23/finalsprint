package com.creditcard.service;

import java.util.List;

import com.creditcard.entities.Admin;
import com.creditcard.exception.AdminNotFoundException;

public interface AdminService {

	Admin addAdmin(Admin admin);

	Admin getAdmin(int adminId);

	List<Admin> getAllAdmins();

	Admin validateAdmin(String userName, String password) throws AdminNotFoundException;

	Admin getAdminById(Integer adminId) throws AdminNotFoundException;

}
