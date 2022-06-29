package com.uca.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Adopter")
public class Adopter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADOPTER_ID")
    Integer idAdopter;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="PET_ID")
    private List<Pet> pet;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;


}
