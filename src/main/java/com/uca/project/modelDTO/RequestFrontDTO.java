package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Setter
@Getter

public class RequestFrontDTO  implements Serializable {


    String message;
    Integer publication;
    String state;
    Integer idUser;


}
