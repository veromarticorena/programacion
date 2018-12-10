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
		
		return empleadoDao.listar();
	}

	public Empleado traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Empleado empleadoAutenticado(String contrasenia, long legajo) {
		// TODO Auto-generated method stub
		return empleadoDao.empleadoAutenticado(contrasenia, legajo);
	}


	@Override
	public Empleado empleadoPorDni(String dni) {
		
		return empleadoDao.empleadoPorDni(dni);
	}


	@Override
	public List<Empleado> empleadosPorRol(long idRol) {
		return empleadoDao.empleadosPorRol(idRol);
	}
	
	
	

}
