package validacion;

import java.util.List;

import entidad.Empleado;
import entidad.Requerimiento;
import error.ErrorRequerimiento;

public class ValidarRequerimiento {
	
	private static ErrorRequerimiento error;
	
	public static ErrorRequerimiento existeRequerimiento(List<Requerimiento> lista, Long numero, Empleado empleado) {
		
		error = new ErrorRequerimiento();
		
		error.setOk(true);
		
		for (Requerimiento r : lista) {
		
			
			if(r.getNumero()==numero&&r.getEmpleado().getDni().equals(empleado.getDni())) {				
				
				error.setOk(false);
			}
			
		
		}

		return error;
		
		
	}

}
