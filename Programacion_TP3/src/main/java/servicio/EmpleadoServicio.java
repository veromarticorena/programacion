package servicio;

import entidad.Empleado;

public interface EmpleadoServicio extends Servicio<Empleado> {
	
	


	Empleado empleadoAutenticado(String contrasenia, long legajo);
}
