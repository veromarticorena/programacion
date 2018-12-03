package entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name = "LICENCIAS")


public class Licencia implements Serializable{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	protected Date fechaInicio;
	
	@Id
	protected Date fechaFin;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DNI_EMPLEADO")
	protected Empleado empleado;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "ID_TIPO")	
	protected TipoLicencia tipoLicencia;
	
	@Column(name="CANTIDAD_DIAS",nullable = false)
	protected Integer cantidadDias;



	public Licencia() {
		// TODO Auto-generated constructor stub
	}







	public Date getFechaInicio() {
		return fechaInicio;
	}







	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}







	public Date getFechaFin() {
		return fechaFin;
	}







	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}







	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public TipoLicencia getTipoLicencia() {
		return tipoLicencia;
	}



	public void setTipoLicencia(TipoLicencia tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}



	public Integer getCantidadDias() {
		return cantidadDias;
	}



	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}







	public Licencia(Date fechaInicio, Date fechaFin, Empleado empleado, TipoLicencia tipoLicencia,
			Integer cantidadDias) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.tipoLicencia = tipoLicencia;
		this.cantidadDias = cantidadDias;
	}





}
