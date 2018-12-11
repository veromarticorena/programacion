package servicio;

import java.util.List;

import entidad.Requerimiento;
import entidad.RqPorEmpleado;

public interface RequerimientoServicio extends Servicio<Requerimiento>{

	 List<Requerimiento> habilitados();
	 List<RqPorEmpleado> habilitadosPorEmpleado(String dni);
	 Requerimiento traerPorNumero(long id);
	 List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero);
	 List<RqPorEmpleado> asignadosPorNumero(long numero);
	 RqPorEmpleado asignadoAEmpleado(long numero, String dni);
}
