package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TareaPk implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Column(name = "FECHA",nullable = false, length = 10 )	
	 protected String fecha;
	 
	 @Column(name = "NUMERO")
	 protected Requerimiento requerimiento;
	 
	 @Column(name = "DNI_EMPLEADO")
	 protected String dni;
	 

	
	public TareaPk() {
		//
	}
	
	
}
