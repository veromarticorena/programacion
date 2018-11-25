package entidad;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "REQUERIMIENTOS")


public class Requerimiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_RQ",nullable = false)
	protected Integer idRequerimiento;
	
	@Column(name="DESCRIPCION",nullable = false)
	protected String descripcion;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "DNI_EMPLEADO")	
	protected Empleado empleado;

	

	public Integer getIdRequerimiento() {
		return idRequerimiento;
	}




	public void setIdRequerimiento(Integer idRequerimiento) {
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




	public Requerimiento(Integer idRequerimiento, String descripcion, Empleado empleado) {
		super();
		this.idRequerimiento = idRequerimiento;
		this.descripcion = descripcion;
		this.empleado = empleado;
	}




	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

}
