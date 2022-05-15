package com.creditcard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.creditcard.entities.Admin;
import com.creditcard.exception.AdminNotFoundException;
import com.creditcard.exception.NotFoundException;
import com.creditcard.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	@Transactional
	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	@Override
	public Admin getAdmin(int Id) {
		return adminRepo.getById(Id);
	}

	@Override
	public Admin getAdminById(Integer adminId) throws AdminNotFoundException {
		if (adminRepo.existsById(adminId)) {
			return adminRepo.getById(adminId);
		}
		return null;
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	@Override
	public Admin validateAdmin(String userName, String password) throws AdminNotFoundException {

		if (!adminRepo.existsByuserName(userName)) {
			throw new AdminNotFoundException("Admin Not Existing");
		}

		Optional<Admin> result = adminRepo.validateAdminCredentials(userName, password);
		if (!result.isPresent()) {
			throw new NotFoundException(" invalidate password");

		}

		return result.get();
	}

}
