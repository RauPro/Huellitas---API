package com.uca.project.modelDTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.IntegralDataTypeHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@Entity
public class RequestDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "request_id")
	Integer request_id;

	@Column(name = "posibleadoptador")
	String posibleadoptador;

	@Column(name = "foto")
    String foto;

	@Column(name = "publicacion")
    String publicacion;

	@Column(name = "direccion")
    String direccion;

	@Column(name = "telefono")
    String telefono;

	@Column(name = "mensaje")
    String mensaje;

	@Column(name = "fechadesolicitud")
    String fechadesolicitud;

	@Column(name = "estado")
    String estado;
	@Column(name = "user_id")
	Integer userId;
	@Column(name = "owner_user_id")
	Integer ownerUserId;
	@Column(name = "publication_id")
	Integer publicationId;
	@Column(name = "comment")
	String comment;

}
