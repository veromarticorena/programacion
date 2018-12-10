package dao;

import entidad.TipoLicencia;

public interface TipoLicenciaDao extends Dao<TipoLicencia> {

	TipoLicencia traer(long id);

}
