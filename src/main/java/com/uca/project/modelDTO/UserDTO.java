package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Setter
@Getter
public class UserDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USER_ID")
    Integer idUser;
    @Column(name="USER_NAME")
    String nameUser;
    @Column(name="AGE")
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
