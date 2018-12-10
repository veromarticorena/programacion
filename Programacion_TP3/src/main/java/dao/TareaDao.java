package dao;

import java.sql.Date;
import java.util.List;

import entidad.Tarea;

public interface TareaDao extends Dao<Tarea> {

	List<Tarea> tareasPorEmpleado(String dni);

	List<Tarea> tareasPorEmpleadoYFecha(String dni, Date fecha);

	List<Tarea> tareasPorEmpleadoYMes(String dni, Integer mes, Integer anio);

	Tarea traer(Date fecha, Long idRequerimiento, String dni);

	List<Tarea> tareasPorRango(String dni, Date fechaInicio, Date fechaFin);

	List<Tarea> tareasPorMes(Integer mes, Integer anio);

	List<Tarea> tareasPorRQ(long numero);

}
