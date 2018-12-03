package entidad;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table (name = "LEGAJOS")

public class Legajo implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_LEGAJO",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long idLegajo;
	
	@Column(name="CONTRASENIA",nullable = false)
	protected String contrasenia;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_ROL")	
	protected Rol rol;
	
	@Column(name="HABILITADO",nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean habilitado;
	
	

	
	public boolean isHabilitado() {
		return habilitado;
	}


	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public Legajo(Long idLegajo, Rol rol, String contrasenia) {
		super();
		this.idLegajo = idLegajo;
		this.rol = rol;
		this.contrasenia = contrasenia;
	}


	public Long getIdLegajo() {
		return idLegajo;
	}


	public void setIdLegajo(Long idLegajo) {
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
