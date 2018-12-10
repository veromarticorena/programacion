package servicio;

import java.util.List;

import entidad.Empleado;

public interface EmpleadoServicio extends Servicio<Empleado> {

	Empleado empleadoAutenticado(String contrasenia, long legajo);
	
	Empleado empleadoPorDni(String dni);
	
	List<Empleado> empleadosPorRol(long idRol);
}
