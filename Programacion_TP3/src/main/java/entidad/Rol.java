package entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "ROLES")

public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_ROL",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected Long idRol;
	
	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;
	
	
	public Rol(Long idRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
	}

	

	public Long getIdRol() {
		return idRol;
	}


	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Rol() {
		// TODO Auto-generated constructor stub
	}

}
