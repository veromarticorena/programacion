package servicio_Impl;

import java.util.List;

import dao.TipoLicenciaDao;
import entidad.TipoLicencia;
import servicio.TipoLicenciaServicio;

public class TipoLicenciaServicioImpl implements TipoLicenciaServicio {
	
	
private TipoLicenciaDao tipoLicenciaDao;
	
	
	public TipoLicenciaServicioImpl(TipoLicenciaDao tipoLicenciaDaoBean) {
		tipoLicenciaDao = tipoLicenciaDaoBean;
	}


	public void agregar(TipoLicencia t) {
		tipoLicenciaDao.agregar(t);		
	}


	public void modificar(TipoLicencia t) {
		tipoLicenciaDao.modificar(t);
		
	}


	public void eliminar(TipoLicencia t) {
		tipoLicenciaDao.eliminar(t);		
	}


	public List<TipoLicencia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public TipoLicencia traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
