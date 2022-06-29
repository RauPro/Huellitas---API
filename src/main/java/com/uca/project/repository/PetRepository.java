package com.uca.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.project.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Integer> {

}
