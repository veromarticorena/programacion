package dao;

import java.util.List;

import entidad.TipoLicencia;

public interface TipoLicenciaDao extends Dao<TipoLicencia> {

	TipoLicencia traer(long id);

	List<TipoLicencia> listar();

}
