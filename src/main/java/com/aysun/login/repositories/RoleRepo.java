package com.aysun.login.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aysun.login.models.Rolle;

@Repository
public interface RoleRepo extends CrudRepository<Rolle, Long> {
    List<Rolle> findAll();
    
    List<Rolle> findByName(String name);
}