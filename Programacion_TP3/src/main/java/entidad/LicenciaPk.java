package entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;


public class LicenciaPk implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="FECHA")
	protected Date fecha;
	
	@Column(name = "DNI_EMPLEADO")
	protected String dni;
	
	 public LicenciaPk() {
		 
		 //
	 }
}
