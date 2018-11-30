package servicio_Impl;

import java.util.List;

import dao.LegajoDao;
import entidad.Legajo;
import servicio.LegajoServicio;

public class LegajoServicioImpl implements LegajoServicio {
	
private LegajoDao legajoDao;
	
	
	public LegajoServicioImpl(LegajoDao legajoDaoBean) {
		legajoDao = legajoDaoBean;
	}


	public void agregar(Legajo t) {
		legajoDao.agregar(t);		
	}


	public void modificar(Legajo t) {
		legajoDao.modificar(t);
		
	}


	public void eliminar(Legajo t) {
		legajoDao.eliminar(t);		
	}


	public List<Legajo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Legajo traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
