package com.aysun.login.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aysun.login.models.*;
import com.aysun.login.repositories.*;

@Service
public class UserService {
	
	private UserRepo userRepo;
    private RoleRepo roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(
    		UserRepo userRepo,
    		RoleRepo roleRepo,
    		BCryptPasswordEncoder bCryptPasswordEncoder) {
    		
    		this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public void saveWithUserRole(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_USER"));
        userRepo.save(user);
    }
    
    public void saveUserWithAdminRole(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    
    public List<Users> getAllUsers() {
    		return (List<Users>) userRepo.findAll();
    }
    
    public List<Users> getAllUsersByRole(Rolle role) {
    		return userRepo.findAllByRolesContaining(role);
    }
    
    public Users getUserById(Long id) {
    		return userRepo.findOne(id);
    }
    
    public void deleteUser(Long id) {
    		userRepo.delete(id);
    }
    
    public void updateUser(Users user) {
    		userRepo.save(user);
    }
    
    public Rolle getRoleById(Long id) {
    		return roleRepo.findOne(id);
    }
}