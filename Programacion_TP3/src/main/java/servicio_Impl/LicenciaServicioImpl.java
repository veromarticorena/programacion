package servicio_Impl;

import java.sql.Date;
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

		
	@Override
	public List<Licencia> licenciaPorEmpleado(String dni) {
		
		return licenciaDao.licenciaPorEmpleado(dni);
	}


	@Override
	public List<Licencia> licenciaPorEmpleadoYMes(String dni, Integer mes,Integer anio) {
		// TODO Auto-generated method stub
		return licenciaDao.licenciaPorEmpleadoYMes(dni,mes,anio);
	}


	@Override
	public Licencia licenciaPorEmpleadoYFecha(String dni, Date fecha) {
		// TODO Auto-generated method stub
		return licenciaDao.licenciaPorEmpleadoYFecha(dni, fecha);
	}


	@Override
	public Licencia traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Licencia> licenciasPorMes(Integer mes, Integer anio) {
		// TODO Auto-generated method stub
		return licenciaDao.licenciasPorMes(mes, anio);
	}

}
