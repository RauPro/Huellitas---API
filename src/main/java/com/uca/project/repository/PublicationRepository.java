package com.uca.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.project.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication,Integer>{
}