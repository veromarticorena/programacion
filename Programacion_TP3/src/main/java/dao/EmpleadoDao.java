package dao;
import java.util.List;

import entidad.Empleado;

public interface EmpleadoDao extends Dao<Empleado>{

	

	Empleado empleadoAutenticado(String contrasenia, Long legajo);

	Empleado empleadoPorDni(String dni);

	List<Empleado> empleadosPorRol(long idRol);



}
