package servicio_Impl;

import java.util.List;

import dao.LicenciaDao;
import entidad.Licencia;
import servicio.LicenciaServicio;

public class LicenciaServicioImpl implements LicenciaServicio {
	
	private LicenciaDao licenciaDao;
	
	public LicenciaServicioImpl(LicenciaDao licenciaDaoBean) {
		licenciaDao = licenciaDaoBean;
	}


	public void agregar(Licencia t) {
		licenciaDao.agregar(t);		
	}


	public void modificar(Licencia t) {
		licenciaDao.modificar(t);
		
	}


	public void eliminar(Licencia t) {
		licenciaDao.eliminar(t);		
	}


	public List<Licencia> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Licencia traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
