package dao;
import entidad.Empleado;

public interface EmpleadoDao extends Dao<Empleado>{

	

	Empleado empleadoAutenticado(String contrasenia, Long legajo);



}
