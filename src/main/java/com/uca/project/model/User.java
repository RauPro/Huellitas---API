package com.uca.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"User\"")
@Setter
@Getter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    Integer idUser;

    
	@Column(name="USER_NAME")
	String nameUser;
	
	@Column(name="USER_AGE")
     Integer age;

	@Column(name="USER_ADDRESS")
 	String address;

	@Column(name="USER_PICTURE")
	String picture;
	
	@Column(name="USER_PASSWORD")
	String password;
	
	@Column(name="USER_PHONE")
	Integer phone;
	
	@Column(name="USER_EMAIL")
	String email;
	
	@Column(name="USER_DESCRIPTION")
	String description;
	@Column(name="DEPARTMENT")
	String department;
}
