package entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table (name = "EMPLEADOS")

public class Empleado  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DNI",nullable = false)
	protected String dni;
	
	@Column(name="NOMBRE",nullable = false)
	protected String nombre;
	
	@Column(name="APELLIDO")
	protected String apellido;
	
	@Column(name="FECHA_NAC",nullable = false)
	protected Date fechaNac;
	
	@Column(name="FECHA_ING",nullable = false)
	protected Date fechaIngreso;
	
	@Column(name="SALDO_VAC",nullable = false)
	protected Integer saldoVacaciones;
	
	@Column(name="SALDO_EXAMEN",nullable = false)
	protected Integer saldoExamen;
	
	@Column(name="EMAIL",nullable = false)
	protected String email;
	
	@Column(name="TELEFONO",nullable = false)
	protected String telefono;
	
	//
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_LEGAJO")
	protected Legajo legajo;
	
	//
	@ManyToOne(cascade={CascadeType.ALL})	
	@JoinColumn(name = "DNI_SUPERVISOR")
	protected Empleado empleado;	
	
	//
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_SECTOR")
	protected Sector sector;
	
	
	@Column(name="HABILITADO",nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean habilitado;
	
	
	
	

	public boolean isHabilitado() {
		return habilitado;
	}


	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public Empleado() {
		// TODO Auto-generated constructor stub
	}


	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Integer getSaldoVacaciones() {
		return saldoVacaciones;
	}


	public void setSaldoVacaciones(Integer saldoVacaciones) {
		this.saldoVacaciones = saldoVacaciones;
	}


	public Integer getSaldoExamen() {
		return saldoExamen;
	}


	public void setSaldoExamen(Integer saldoExamen) {
		this.saldoExamen = saldoExamen;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Legajo getLegajo() {
		return legajo;
	}


	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Sector getSector() {
		return sector;
	}


	public void setSector(Sector sector) {
		this.sector = sector;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Empleado(String dni, String nombre, String apellido, Date fechaNac, Date fechaIngreso,
			Integer saldoVacaciones, Integer saldoExamen, String email, String telefono, Legajo legajo,
			Empleado empleado, Sector sector, Boolean habilitado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.fechaIngreso = fechaIngreso;
		this.saldoVacaciones = saldoVacaciones;
		this.saldoExamen = saldoExamen;
		this.email = email;
		this.telefono = telefono;
		this.legajo = legajo;
		this.empleado = empleado;
		this.sector = sector;
		this.habilitado = habilitado;
	}


	

}
