package com.waquar.springcloud.productservice.repository;

import com.waquar.springcloud.productservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
