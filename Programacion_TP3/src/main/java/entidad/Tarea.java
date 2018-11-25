package entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


@Entity
@Table (name = "TAREAS")


public class Tarea implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="FECHA",nullable = false)
	protected Date fecha;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_RQ")
	protected Requerimiento requerimiento;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DNI_EMPLEADO")
	protected Empleado empleado;
	
	
	
	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	@Column(name="HORAS",nullable = false)
	protected Integer horas;



	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Requerimiento getRequerimiento() {
		return requerimiento;
	}


	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}


	
	public Integer getHoras() {
		return horas;
	}


	public void setHoras(Integer horas) {
		this.horas = horas;
	}


	public Tarea() {
		// TODO Auto-generated constructor stub
	}

}
