package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
public class OwnerDTO implements Serializable {
    @Id
    @Column(name = "owner_id")
    Integer idOwner;
    @Column(name = "user_id")
    Integer userId;

    @Column(name="pet_id")
    Integer pet;
}
