package com.stefanovich.enovation.repository;

import com.stefanovich.enovation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
