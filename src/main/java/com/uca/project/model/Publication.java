package com.uca.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "PUBLICATION")
public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_id")
    Owner owner;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pet_id")
    Pet pet;



}
