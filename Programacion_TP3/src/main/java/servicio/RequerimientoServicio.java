package servicio;

import java.util.List;

import entidad.Requerimiento;

public interface RequerimientoServicio extends Servicio<Requerimiento>{

	 List<Requerimiento> habilitados();
	 List<Requerimiento> habilitadosPorEmpleado(String dni);
	 List<Requerimiento> traerPorNumero(long id);
	 List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero);
}
