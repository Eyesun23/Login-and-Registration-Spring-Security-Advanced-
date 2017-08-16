package com.aysun.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.login.models.Rolle;
import com.aysun.login.models.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Long> {
	Users findByUsername(String username);
	List<Users> findAllByRolesContaining(Rolle role);
}