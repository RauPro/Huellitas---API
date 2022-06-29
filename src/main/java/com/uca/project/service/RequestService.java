package com.uca.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.project.model.Request;
import com.uca.project.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	RequestRepository requestRepository;
	
	public List<Request> getAll() {
        return requestRepository.findAll();
    }
	
}
