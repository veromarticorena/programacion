package servicio_Impl;

import java.util.List;

import dao.EmpleadoDao;
import entidad.Empleado;
import servicio.EmpleadoServicio;

public class EmpleadoServicioImpl implements  EmpleadoServicio{
	
	private EmpleadoDao empleadoDao;
	
	
	public EmpleadoServicioImpl(EmpleadoDao empleadoDaoBean) {
		empleadoDao = empleadoDaoBean;
	}


	public void agregar(Empleado t) {
		empleadoDao.agregar(t);		
	}


	public void modificar(Empleado t) {
		empleadoDao.modificar(t);
		
	}


	public void eliminar(Empleado t) {
		empleadoDao.eliminar(t);		
	}


	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
