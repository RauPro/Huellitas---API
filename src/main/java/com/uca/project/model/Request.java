package com.uca.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "REQUEST")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    Integer request_id;

    @Column(name="MESSAGE")
    String message;

    @Column(name = "state")
    String state;

    @Column(name = "date_of_request")
    String date_of_request;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="adopter_id")
    Adopter adopter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PUBLICATION_ID")
    Publication publication;
    @Column(name = "comment")
    String comment;

}
