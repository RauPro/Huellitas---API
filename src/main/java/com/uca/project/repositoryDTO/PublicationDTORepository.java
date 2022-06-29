package com.uca.project.repositoryDTO;

import com.uca.project.modelDTO.PublicationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublicationDTORepository extends JpaRepository<PublicationDTO,Integer> {
    @Query(value = "SELECT publication_id, owner_id, publication_date, pet_id, title, description " +
            " FROM public.publication;" ,nativeQuery = true)
    List<PublicationDTO> getPublications();
    
    @Query(value= "SELECT p.publication_id, u.user_id, p.publication_date, p.pet_id, p.title  , e.pet_id as id_pet, p.description, e.petdescription, e.pet_name, p.owner_id , e.owner_id, "
    		+ " e.color, e.veterinary_care, e.breed, e.vaccination, e.pet_image, e.species,  e.age, e.size, e.sex as pet_sex, e.pet_image "
    		+ "FROM Publication p, Pet e, public.user u, owner o "
    		+ "WHERE p.pet_id = e.pet_id and u.user_id = o.user_id and o.owner_id = e.owner_id;", nativeQuery=true)
    List<PublicationDTO> getPublicationsDTO();
    
    @Query(value= "SELECT p.publication_id, p.publication_date,u.user_id, p.pet_id, p.title  , e.pet_id as id_pet, p.description, e.petdescription, e.pet_name, p.owner_id , e.owner_id, "
    		+ " e.color, e.veterinary_care, e.breed, e.vaccination, e.pet_image, e.species,  e.age, e.size, e.sex as pet_sex, e.pet_image "
    		+ "FROM Publication p, Pet e,  public.user u, owner o "
    		+ "WHERE e.species = :species and p.pet_id = e.pet_id and u.user_id = o.user_id and o.owner_id = e.owner_id;", nativeQuery=true)
    List<PublicationDTO> getpublicationsCategory(@Param("species") String species);
    
    @Query(value= "SELECT p.publication_id, p.publication_date, p.pet_id, p.title  , e.pet_id as id_pet, p.description, e.petdescription, e.pet_name, p.owner_id , e.owner_id, "
    		+ " e.color, e.veterinary_care, e.breed, e.vaccination, e.pet_image, e.species,  e.age, e.size, e.sex as pet_sex, e.pet_image "
    		+ "FROM Publication p, Pet e "
    		+ "WHERE p.publication_id = :id and e.pet_id = :idUrl", nativeQuery=true)
    PublicationDTO getpublicationID(@Param("id")  Integer id,@Param("idUrl") Integer idUrl);

	@Query(value= "SELECT p.publication_id, p.publication_date, p.pet_id, p.title ,u.user_id , e.pet_id as id_pet, p.description, e.petdescription, e.pet_name, p.owner_id , e.owner_id, "
			+ " e.color, e.veterinary_care, e.breed, e.vaccination, e.pet_image, e.species,  e.age, e.size, e.sex as pet_sex, e.pet_image "
			+ "FROM Publication p, Pet e, public.user u, owner o "
			+ "WHERE p.publication_id = :id and u.user_id = o.user_id and o.owner_id = p.owner_id;", nativeQuery=true)
	PublicationDTO getpublication(@Param("id")  Integer id);



}
