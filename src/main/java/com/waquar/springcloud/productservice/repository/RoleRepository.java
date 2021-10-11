package com.waquar.springcloud.productservice.repository;

import com.waquar.springcloud.productservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
