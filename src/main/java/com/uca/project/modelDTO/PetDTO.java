package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class PetDTO implements Serializable {
    @Id
    @Column(name = "pet_id")
    Integer  petId;

    @Column(name="sex")
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

    @Column(name="owner_id")
    Integer owner;
}
