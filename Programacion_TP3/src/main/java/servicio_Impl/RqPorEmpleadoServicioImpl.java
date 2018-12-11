package servicio_Impl;

import java.util.List;

import dao.RqPorEmpleadoDao;
import entidad.RqPorEmpleado;
import servicio.RqPorEmpleadoServicio;

public class RqPorEmpleadoServicioImpl implements RqPorEmpleadoServicio {
	
	private RqPorEmpleadoDao rqPorEmpleadoDao;
	
	public RqPorEmpleadoServicioImpl(RqPorEmpleadoDao rqPorEmpleadoDaoBean) {
		rqPorEmpleadoDao = rqPorEmpleadoDaoBean;
	}

	@Override
	public void agregar(RqPorEmpleado t) {
		
		rqPorEmpleadoDao.agregar(t);
	}

	@Override
	public void modificar(RqPorEmpleado t) {
		// TODO Auto-generated method stub
		rqPorEmpleadoDao.modificar(t);
	}

	@Override
	public void eliminar(RqPorEmpleado t) {
		// TODO Auto-generated method stub
		rqPorEmpleadoDao.eliminar(t);
	}

	@Override
	public List<RqPorEmpleado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RqPorEmpleado traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
