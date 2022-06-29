package com.uca.project.controller;


import com.uca.project.model.*;
import com.uca.project.modelDTO.MessageDTO;
import com.uca.project.modelDTO.RequestDTO;
import com.uca.project.modelDTO.RequestFrontDTO;
import com.uca.project.repository.*;
import com.uca.project.repositoryDTO.AdopterDTORepository;
import com.uca.project.repositoryDTO.RequestDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/Request")
public class RequestController {

    @Autowired
    RequestDTORepository repositoryDto;
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    AdopterDTORepository adopterDTORepository;

    @PostMapping(value = {"/sendRequest"})

    public Map<String,String> sendRequest(@RequestBody RequestFrontDTO requestObject){
        Map<String,String> map = new HashMap<>();
        Adopter adopter = new Adopter();
        adopter.setIdAdopter(adopterDTORepository.getIdAdopter(requestObject.getIdUser()));
        Publication publication = publicationRepository.findById(requestObject.getPublication()).orElse(new Publication());
        User user = profileRepository.findById(requestObject.getIdUser()).orElse(new User());
        Request request = new Request();
        request.setPublication(publication);
        request.setState(requestObject.getState());
        request.setMessage(requestObject.getMessage());
        request.setDate_of_request(new Date().toString());
        /*  request.setContact(user.getPhone());*/
        request.setAdopter(adopter);
        requestRepository.save(request);
        map.put("Message","Success");


        return map;

    }

    @PutMapping(value = {"/acceptRequest/{id}"})

    public Map<String,String> acceptRequest(@PathVariable(name = "id") Integer id, @RequestBody MessageDTO messageDTO){
        Map<String,String> map = new HashMap<>();
        Request request = requestRepository.getById(id);
        request.setState("Aceptado");
        request.setComment(messageDTO.getComment());
        repositoryDto.updateStateRequest(request.getPublication().getIdPublication(), request.getRequest_id());
        repositoryDto.updateStateRequestAccepted(request.getPublication().getIdPublication(), request.getRequest_id());
        requestRepository.save(request);
        map.put("Message","Success");
        return map;

    }
    @PutMapping(value = {"/rejectRequest/{id}"})

    public Map<String,String> rejectRequest(@PathVariable(name = "id") Integer id, @RequestBody MessageDTO messageDTO){
        Map<String,String> map = new HashMap<>();
        Request request = requestRepository.getById(id);
        request.setState("Rechazado");
        request.setComment(messageDTO.getComment());
        requestRepository.save(request);
        repositoryDto.updateStateRequestRejected(request.getPublication().getIdPublication(), request.getRequest_id());
        map.put("Message","Success");
        return map;

    }
    @GetMapping("/getAll")
    public List<RequestDTO> getAllRequests(){
        return repositoryDto.getRequestDTO();
    }



}
