package servicio_Impl;

import java.util.List;

import dao.SectorDao;
import entidad.Sector;
import servicio.SectorServicio;

public class SectorServicioImpl implements SectorServicio {
	
	
private SectorDao sectorDao;
	
	
	public SectorServicioImpl(SectorDao sectorDaoBean) {
		sectorDao = sectorDaoBean;
	}


	public void agregar(Sector t) {
		sectorDao.agregar(t);		
	}


	public void modificar(Sector t) {
		sectorDao.modificar(t);
		
	}


	public void eliminar(Sector t) {
		sectorDao.eliminar(t);		
	}


	public List<Sector> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sector traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
