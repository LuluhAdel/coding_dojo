package com.luluh.auth.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.luluh.auth.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}