package entidad;

import java.io.Serializable;

import javax.persistence.*;


public class LicenciaPk implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="FECHA")
	protected String fecha;
	
	@Column(name = "DNI_EMPLEADO")
	protected String dni;
	
	 public LicenciaPk() {
		 
		 //
	 }
}
