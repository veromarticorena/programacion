package dao;

import java.sql.Date;
import java.util.List;

import entidad.Licencia;

public interface LicenciaDao extends Dao<Licencia> {

	List<Licencia> licenciaPorEmpleado(String dni);

	List<Licencia> licenciaPorEmpleadoYMes(String dni, Integer mes, Integer anio);

	Licencia licenciaPorEmpleadoYFecha(String dni, Date fecha);

	List<Licencia> licenciasPorMes(Integer mes, Integer anio);

	
}
