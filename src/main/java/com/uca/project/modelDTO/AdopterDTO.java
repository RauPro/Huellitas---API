package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class AdopterDTO implements Serializable {
    @Id
    @Column(name = "id_adopter")
    Integer idAdopter;
    @Column(name="id_pet")
    Integer pet;
    @Column(name = "user_id")
    Integer user;

}
