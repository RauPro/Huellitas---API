package com.uca.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.project.model.User;

public interface ProfileRepository extends JpaRepository<User, Integer> {
}
