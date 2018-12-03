package servicio_Impl;

import java.util.List;

import dao.RequerimientoDao;
import entidad.Requerimiento;
import servicio.RequerimientoServicio;

public class RequerimientoServicioImpl implements RequerimientoServicio {
	
private RequerimientoDao requerimientoDao;
	
	
	public RequerimientoServicioImpl(RequerimientoDao requerimientoDaoBean) {
		requerimientoDao = requerimientoDaoBean;
	}


	public void agregar(Requerimiento t) {
		requerimientoDao.agregar(t);		
	}


	public void modificar(Requerimiento t) {
		requerimientoDao.modificar(t);
		
	}


	public void eliminar(Requerimiento t) {
		requerimientoDao.eliminar(t);		
	}


	public List<Requerimiento> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Requerimiento traer(long id) {
		// TODO Auto-generated method stub
		return requerimientoDao.traer(id);
	}
	
	public List<Requerimiento> habilitados() {
		return requerimientoDao.habilitados();		
	}
	
	public List<Requerimiento> habilitadosPorEmpleado(String dni) {
		return requerimientoDao.habilitadosPorEmpleado(dni);		
	}


	@Override
	public List<Requerimiento> traerPorNumero(long numero) {		
		
		return requerimientoDao.traerPorNumero(numero);
	}

	@Override
	public List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero) {		
		
		return requerimientoDao.traerPorNumeroYEmpleado(dni, numero);
	}

	

}
