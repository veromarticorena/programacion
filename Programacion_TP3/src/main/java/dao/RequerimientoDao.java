package dao;

import java.util.List;

import entidad.Requerimiento;
import entidad.RqPorEmpleado;

public interface RequerimientoDao extends Dao<Requerimiento>{

	List<RqPorEmpleado> habilitadosPorEmpleado(String dni);

	List<Requerimiento> habilitados();

	Requerimiento traerPorNumero(long numero);
	
	List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero);

	List<RqPorEmpleado> asignadosPorNumero(long numero);

	RqPorEmpleado asignadoAEmpleado(long numero, String dni);

}
