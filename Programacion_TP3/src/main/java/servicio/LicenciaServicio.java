package servicio;

import java.util.List;

import entidad.Licencia;

public interface LicenciaServicio  extends Servicio<Licencia>{

	List<Licencia> licenciaPorEmpleado(String dni);

}
