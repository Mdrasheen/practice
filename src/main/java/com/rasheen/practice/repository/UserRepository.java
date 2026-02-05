package com.rasheen.practice.repository;

import com.rasheen.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
