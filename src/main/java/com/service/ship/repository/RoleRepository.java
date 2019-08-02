package com.service.ship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ship.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	List<String> findRoleNameByUserId(long id);
}
