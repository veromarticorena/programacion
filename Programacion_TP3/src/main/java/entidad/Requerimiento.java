package entidad;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table (name = "REQUERIMIENTOS")


public class Requerimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="NUMERO",nullable = false)
	protected Long numero;	

	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;
		
	@Column(name="HABILITADO",nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean habilitado;
	

	

	public Long getNumero() {
		return numero;
	}


	public void setNumero(Long numero) {
		this.numero = numero;
	}


	public boolean isHabilitado() {
		return habilitado;
	}




	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Requerimiento(String descripcion, Empleado empleado,Long numero) {
		super();
		
		this.descripcion = descripcion;
		this.numero = numero;
	}




	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

}
