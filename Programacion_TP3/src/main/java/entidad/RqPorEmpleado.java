package entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name = "RQ_POR_EMPLEADO")
public class RqPorEmpleado  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NUMERO")
	protected Requerimiento requerimiento;	
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DNI_EMPLEADO")
	protected Empleado empleado;

	
	
	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public RqPorEmpleado() {
		// TODO Auto-generated constructor stub
	}

}
