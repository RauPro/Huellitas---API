package com.uca.project.repository;

import com.uca.project.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.project.model.Request;

public interface AdoptRepository extends JpaRepository<Adopter,Integer>{


}