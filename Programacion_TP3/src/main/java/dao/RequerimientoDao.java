package dao;

import java.util.List;

import entidad.Requerimiento;

public interface RequerimientoDao extends Dao<Requerimiento>{

	List<Requerimiento> habilitadosPorEmpleado(String dni);

	List<Requerimiento> habilitados();

	List<Requerimiento> traerPorNumero(long numero);
	
	Requerimiento traer(long id);

	List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero);

}
