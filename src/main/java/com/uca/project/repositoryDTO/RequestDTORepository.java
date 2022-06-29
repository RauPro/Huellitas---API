package com.uca.project.repositoryDTO;

import com.uca.project.modelDTO.RequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestDTORepository extends JpaRepository<RequestDTO,Integer> {
    @Query(value = "select r.request_id,p.publication_id, r.comment, u.user_id, o.user_id as owner_user_id,  u.user_name as posibleAdoptador, u.user_picture as foto,  u.user_phone as telefono, u.user_address as direccion, p.title as publicacion, r.message as mensaje, r.date_of_request as fechaDeSolicitud, r.state as estado"
    		+ "	from public.user u, adopter a, request r,  publication p, Owner o"
    		+ "	where u.user_id = a.id_user and r.adopter_id = a.adopter_id and r.publication_id = p.publication_id and o.owner_id = p.owner_id;" ,nativeQuery = true)
    List<RequestDTO> getRequestDTO();


    @Modifying
    @Transactional
    @Query(value = "UPDATE request " +
            "SET state = 'Aceptado' " +
            "WHERE publication_id = :id and request_id = :request", nativeQuery = true)
    void updateStateRequestAccepted(@Param("id")  Integer id, @Param("request")  Integer request);

    @Modifying
    @Transactional
    @Query(value = "UPDATE request " +
            "SET state = 'Rechazado' " +
            "WHERE publication_id = :id and request_id <> :request", nativeQuery = true)
    void updateStateRequest(@Param("id")  Integer id, @Param("request")  Integer request);

    @Modifying
    @Transactional
    @Query(value = "UPDATE request " +
            "SET state = 'Rechazado' " +
            "WHERE publication_id = :id and request_id = :request", nativeQuery = true)
    void updateStateRequestRejected(@Param("id")  Integer id, @Param("request")  Integer request);
}
