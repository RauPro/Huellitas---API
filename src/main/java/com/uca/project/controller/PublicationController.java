package com.uca.project.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uca.project.model.*;
import com.uca.project.modelDTO.PetDTO;
import com.uca.project.modelDTO.PublicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uca.project.repositoryDTO.OwnerDTORepository;
import com.uca.project.repository.OwnerRepository;
import com.uca.project.repositoryDTO.PetDTORepository;
import com.uca.project.repository.PetRepository;
import com.uca.project.repositoryDTO.PublicationDTORepository;
import com.uca.project.repository.PublicationRepository;



@RestController
@CrossOrigin
@RequestMapping("/")
public class PublicationController {

    @Autowired
    PublicationDTORepository publicationRepositoryDTO;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    PetDTORepository petRepositoryDTO;
    @Autowired
    PetRepository petRepository;

    @Autowired
    PetDTORepository petDTORepository;
    @Autowired
    OwnerDTORepository ownerRepositoryDTO;
    @Autowired
    OwnerRepository ownerRepository;


    @RequestMapping(value={"/findAllPublications"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    List<PublicationDTO> AllPublication(){
        return publicationRepositoryDTO.getPublicationsDTO();
    }
    @RequestMapping(value={"/filter/{species}"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<PublicationDTO> filterCategory(@PathVariable(name = "species") String species) {
		
		return publicationRepositoryDTO.getpublicationsCategory(species);
	}


    @RequestMapping(value={"/publicacion/{id}"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public PublicationDTO findPublicationByID(@PathVariable(name = "id") Integer id) {

        PublicationDTO publicationDTO = publicationRepositoryDTO.getpublication(id);

       PetDTO pet = petDTORepository.getIdPet(publicationDTO.getIdPet());
            publicationDTO.setIdPet(pet.getPetId());
            publicationDTO.setPetAge(pet.getPetAge());
            publicationDTO.setPetDescript(pet.getPetDescript());
            publicationDTO.setPetName(pet.getPetName());
            publicationDTO.setPetBreed(pet.getPetBreed());
            publicationDTO.setPetColor(pet.getPetColor());
            publicationDTO.setPetImage(pet.getPetImage());
            //publicationDTO.setDescription(pet.getPetDescript());
            publicationDTO.setIdOwner(pet.getOwner());
            publicationDTO.setSpecies(pet.getSpecies());
            publicationDTO.setVaccinePet(pet.isVaccinePet());
            publicationDTO.setPetSex(pet.getPetSex());
            publicationDTO.setSize(pet.getSize());



		return publicationDTO;
	}


    @RequestMapping(value = "/newPublication", method = RequestMethod.POST)
    public String newPublication(@ModelAttribute("publication") Publication publication, Pet pet,ModelMap map) {
        /*boolean error=false;
      if(publication.getTittle()==null || publication.getTittle().isEmpty()  ){
          map.put("tittleError","Tittle is required it");
          error = true;
      }
      if(publication.getDescription()==null || publication.getDescription().isEmpty() ){
          map.put("descriptionError","Description is required it");
          error = true;
      }
     if(pet.getPetName()==null || pet.getPetName().isEmpty() ){
         map.put("nameError","Name is required it");
         error = true;
     }
     if(pet.getSpecies()==null || pet.getSpecies().isEmpty() ){
         map.put("specieError","Species is required it");
         error = true;
     }
     if(pet.getPetBreed()==null || pet.getPetBreed().isEmpty()){
         map.put("breedError","Breed is required it");
         error = true;
     }


    if(pet.getPetColor()==null || pet.getPetColor().isEmpty() ){
        map.put("ColorError","Color is required it");
        error = true;
    }
    if(pet.getPetAge()==null  ){
        map.put("AgeError","Age is required it");
        error = true;
    }
    if(pet.getPetSex()==null  || pet.getPetSex().isEmpty() ){
        map.put("sexError","Sex is required it");
        error = true;
    }
    if(pet.getSize()==null  || pet.getSize().isEmpty() ){
        map.put("sizeError","Size is required it");
        error = true;
    }
     if(!pet.getVeterynaryCare()){
        map.put("VeterinaryError","Veterinary control is required it");
        error = true;
    }
     if(!pet.getVaccinePet()){
        map.put("vaccineError","this spaces is required it");
        error = true;
    }
        if(!error){
            publicationRepositoryDTO.save(publication);
            return "success";
        }*/


        return "exit";

    }


   /* @RequestMapping(value = "/deletePublication", method = RequestMethod.DELETE)
    public @ResponseBody
    String deletePublication(@RequestParam Integer ID) {
        PublicationRepository.deleteById(ID);
        return "exit";
    }*/
    @RequestMapping(value = "/createPublication", method = RequestMethod.POST)
    Map<String, String> createPublication(@RequestBody PublicationDTO publication) {
        HashMap<String, String> map = new HashMap<>();
        
        try {
        	
        	System. out. println(publication.getPetName());
        	System. out. println(publication.getPetSex());
        	
        	
        	Owner mock = new Owner();
        	
        	
            mock.setIdOwner(ownerRepositoryDTO.findOwner(publication.getIdOwner()).getIdOwner());
            
            
        	Pet newPet = new Pet();
        	
      
            newPet.setPetName(publication.getPetName());
            newPet.setOwner(mock);  //idOwner
            newPet.setPetColor(publication.getPetColor());
            newPet.setPetBreed(publication.getPetBreed());
            newPet.setVeterynaryCare(publication.isVeterynaryCare());
            newPet.setVaccinePet(publication.isVaccinePet());
            newPet.setPetImage(publication.getPetImage());
            newPet.setSpecies(publication.getSpecies());
            newPet.setPetAge(publication.getPetAge());
            newPet.setPetSex(publication.getPetSex());
            newPet.setSize(publication.getSize());
            newPet.setPetDescript(publication.getPetDescript());
            petRepository.save(newPet);
            

            Publication newPublication = new Publication();
            LocalDate date_of_today = LocalDate.now();
            
            newPublication.setIdPublication(publication.getIdPublication());
            newPublication.setPublicationDate(date_of_today.toString());
            newPublication.setDescription(publication.getDescription());
            newPublication.setTittle(publication.getTittle());
            newPublication.setOwner(mock);
            newPublication.setPet(newPet);
            publicationRepository.save(newPublication);
            map.put("message", "Successful publication");
            
        }catch(Exception e) {
        	map.put("message", "Something Went Wrong with the Pet "+ e);
        }
        return map;
        
        
       
    }


    
    /*@RequestMapping(value = "/modifyPublication", method = RequestMethod.DELETE)
    public @ResponseBody
    String modifyPublication(@RequestParam Integer ID) {
        PublicationRepository.deleteById(ID);
        return "exit";
    }*/

}