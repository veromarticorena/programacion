package entidad;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table (name = "REQUERIMIENTOS")


public class Requerimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_RQ",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected Long idRequerimiento;
	

	@Column(name="NUMERO",nullable = false)
	protected Long numero;
	

	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "DNI_EMPLEADO")	
	protected Empleado empleado;
	
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




	public Long getIdRequerimiento() {
		return idRequerimiento;
	}




	public void setIdRequerimiento(Long idRequerimiento) {
		this.idRequerimiento = idRequerimiento;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Empleado getEmpleado() {
		return empleado;
	}




	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}




	public Requerimiento(Long idRequerimiento, String descripcion, Empleado empleado) {
		super();
		this.idRequerimiento = idRequerimiento;
		this.descripcion = descripcion;
		this.empleado = empleado;
	}




	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

}
