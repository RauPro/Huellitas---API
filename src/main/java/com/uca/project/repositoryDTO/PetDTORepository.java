package com.uca.project.repositoryDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.project.modelDTO.PetDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetDTORepository extends JpaRepository<PetDTO,Integer> {
    @Query(value = "select  p.id_pet as id_pet" ,nativeQuery = true)
    List<PetDTO> getPetDTO();


    @Query(value = "select e.pet_id, e.pet_name, e.owner_id, e.color, e.veterinary_care, e.breed, e.vaccination, e.pet_image, e.species, e.age, e.size, e.petdescription , e.sex from Pet e where e.pet_id = :id ",nativeQuery = true)
        PetDTO getIdPet(@Param("id") Integer id);
}
