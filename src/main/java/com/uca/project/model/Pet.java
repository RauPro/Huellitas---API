package com.uca.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "pet")
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "pet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer  petId;

    @Column(name="SEX")
    String petSex;

    @Column(name="PET_NAME")
    String petName;

    @Column(name="COLOR")
    String petColor;

    @Column(name="VETERINARY_CARE")
    boolean veterynaryCare;

    public boolean getVeterynaryCare() {
        return veterynaryCare;
    }

    @Column(name="BREED")
    String petBreed;

    @Column(name="VACCINATION")
    boolean vaccinePet;
    public boolean getVaccinePet() {
        return vaccinePet;
    }
    @Column(name="PET_IMAGE")
    String petImage;

    @Column(name="SPECIES")
    String species;

    @Column(name="AGE")
    Integer petAge;


    @Column(name="SIZE")
    String size;

    @Column(name="PETDESCRIPTION")
    String petDescript;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    private Owner owner;




}
