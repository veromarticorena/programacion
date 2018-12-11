package servicio_Impl;

import java.util.List;

import dao.RequerimientoDao;
import entidad.Requerimiento;
import entidad.RqPorEmpleado;
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

	
	public List<Requerimiento> habilitados() {
		return requerimientoDao.habilitados();		
	}
	
	public List<RqPorEmpleado> habilitadosPorEmpleado(String dni) {
		return requerimientoDao.habilitadosPorEmpleado(dni);		
	}


	@Override
	public Requerimiento traerPorNumero(long numero) {		
		
		return requerimientoDao.traerPorNumero(numero);
	}

	@Override
	public List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero) {		
		
		return requerimientoDao.traerPorNumeroYEmpleado(dni, numero);
	}


	@Override
	public Requerimiento traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RqPorEmpleado> asignadosPorNumero(long numero) {
		return requerimientoDao.asignadosPorNumero(numero);
	}


	@Override
	public RqPorEmpleado asignadoAEmpleado(long numero, String dni) {
		// TODO Auto-generated method stub
		return requerimientoDao.asignadoAEmpleado(numero, dni);
	}

	

}
