package dao;

import java.util.List;

import entidad.Licencia;

public interface LicenciaDao extends Dao<Licencia> {

	List<Licencia> licenciaPorEmpleado(String dni);

}
