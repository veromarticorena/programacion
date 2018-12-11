package servicio_Impl;

import java.util.List;

import dao.RolDao;
import entidad.Rol;
import servicio.RolServicio;

public class RolServicioImpl implements RolServicio {
	
private RolDao rolDao;
	
	
	public RolServicioImpl(RolDao rolDaoBean) {
		rolDao = rolDaoBean;
	}


	public void agregar(Rol t) {
		rolDao.agregar(t);		
	}


	public void modificar(Rol t) {
		rolDao.modificar(t);
		
	}


	public void eliminar(Rol t) {
		rolDao.eliminar(t);		
	}


	public List<Rol> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Rol traer(long id) {
		// TODO Auto-generated method stub
		return rolDao.traer(id);
	}

}
