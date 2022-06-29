package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class PublicationDTO implements Serializable {
    @Id
    @Column(name = "publication_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPublication;

    @Column(name="publication_date")
    String publicationDate;

    @Column(name="title")
    String tittle;

    @Column(name="description")
    String description;

    @Column(name="owner_id")
    Integer idOwner;
    
    //para la publicacion
    @Column(name="pet_id")
    Integer idPet;
    
    //--------------------Pet
    
    @Column(name = "id_pet")
    Integer  petId;

    @Column(name="pet_sex")
    String petSex;

    @Column(name="pet_name")
    String petName;

    @Column(name="color")
    String petColor;

    @Column(name="veterinary_care")
    boolean veterynaryCare;

    @Column(name="breed")
    String petBreed;

    @Column(name="vaccination")
    boolean vaccinePet;

    @Column(name="pet_image")
    String petImage;

    @Column(name="species")
    String species;

    @Column(name="age")
    Integer petAge;

    @Column(name="size")
    String size;

    @Column(name="petdescription")
    String petDescript;
    @Column(name = "user_id")
    Integer userId;
}
