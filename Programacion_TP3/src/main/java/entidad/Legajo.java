package entidad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table (name = "LEGAJOS")

public class Legajo implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_LEGAJO",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer idLegajo;
	
	@Column(name="CONTRASENIA",nullable = false)
	protected String contrasenia;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_ROL")	
	protected Rol rol;
	

	
	public Legajo(Integer idLegajo, Rol rol, String contrasenia) {
		super();
		this.idLegajo = idLegajo;
		this.rol = rol;
		this.contrasenia = contrasenia;
	}


	public Integer getIdLegajo() {
		return idLegajo;
	}


	public void setIdLegajo(Integer idLegajo) {
		this.idLegajo = idLegajo;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Legajo() {
		// TODO Auto-generated constructor stub
	}

}
