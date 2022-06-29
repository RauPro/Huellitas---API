package com.uca.project.controller;

import java.util.List;

import com.uca.project.modelDTO.RequestDTO;
import com.uca.project.repositoryDTO.RequestDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.uca.project.repository.AdoptRepository;




@RestController
@RequestMapping(path = "adopter")
public class AdoptController {


    @Autowired
    AdoptRepository adoptRepository;
    @Autowired
    RequestDTORepository RequestDTORepository;

    @RequestMapping(value={"/findAllRequest"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    List<RequestDTO> AllRequest(){
        List<RequestDTO>request = RequestDTORepository.findAll();
        return request;
    }
/*
    @RequestMapping(value = "/newRequest", method = RequestMethod.POST)
    public String newPublication(@ModelAttribute("Request") Request request, ModelMap map){
        boolean error=false;
        if(request.getMessage()==null || request.getMessage().isEmpty() ){
            map.put("messageError","Message is required it");
            error = true;
        }
        }
          if(request.getContact()==null){
             map.put("ContactError","Contact is required it");
             error = true;
         }

        if(!error){
            //adoptRepository.save(request);
            return "success";
        }

        return "exit";

    }*/

    @RequestMapping(value = "/deleteRequest", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteRequest(@RequestParam Integer ID) {
        adoptRepository.deleteById(ID);
        return "exit";
    }


    @RequestMapping(value = "/modifyRequest", method = RequestMethod.DELETE)
    public @ResponseBody
    String modifyRequest(@RequestParam Integer ID) {
        adoptRepository.deleteById(ID);
        return "exit";
    }




}
