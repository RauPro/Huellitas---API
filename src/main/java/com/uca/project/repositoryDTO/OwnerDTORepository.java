package com.uca.project.repositoryDTO;

import com.uca.project.modelDTO.OwnerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerDTORepository extends JpaRepository<OwnerDTO,Integer> {
    @Query(value = "select  p.id_owner as id_owner" ,nativeQuery = true)
    List<OwnerDTO> getOwnerDTO();
    
    @Query(value = "select * from owner where  user_id = :idUser" ,nativeQuery = true)
    OwnerDTO findOwner(@Param("idUser") Integer idUser);
    
}
