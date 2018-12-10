package servicio;

import entidad.TipoLicencia;

public interface TipoLicenciaServicio extends Servicio<TipoLicencia>{
	
	TipoLicencia traer(long id);

}
