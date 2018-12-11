package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RqPorEmpleadoPk  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="NUMERO",nullable = false)
	protected Requerimiento requerimiento;	
	 
	 @Column(name = "DNI_EMPLEADO")
	 protected Empleado empleado;
	 
	 
	public RqPorEmpleadoPk(){
		
		//
	}
}
