package com.uca.project.repositoryDTO;

import com.uca.project.modelDTO.AdopterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdopterDTORepository extends JpaRepository<AdopterDTO,Integer> {
    @Query(value = "select  p.id_adopter as id_adopter" ,nativeQuery = true)
    List<AdopterDTO> getAdopters();

    @Query(value = "select a.ADOPTER_ID from Adopter a  where a.ID_USER =:params ",nativeQuery = true)
    Integer getIdAdopter(@Param("params") Integer params);

}
