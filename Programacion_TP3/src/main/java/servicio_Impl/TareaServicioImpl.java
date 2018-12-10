package servicio_Impl;

import java.sql.Date;
import java.util.List;

import dao.TareaDao;
import entidad.Tarea;
import servicio.TareaServicio;

public class TareaServicioImpl implements TareaServicio{
	
	
private TareaDao tareaDao;
	
	
	public TareaServicioImpl(TareaDao tareaDaoBean) {
		tareaDao = tareaDaoBean;
	}


	public void agregar(Tarea t) {
		tareaDao.agregar(t);		
	}


	public void modificar(Tarea t) {
		tareaDao.modificar(t);
		
	}


	public void eliminar(Tarea t) {
		tareaDao.eliminar(t);		
	}


	public List<Tarea> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tarea traer(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Tarea> tareasPorEmpleado(String dni) {
		
		return tareaDao.tareasPorEmpleado(dni);
	}


	@Override
	public List<Tarea> tareasPorEmpleadoYFecha(String dni, Date fecha) {
		// TODO Auto-generated method stub
		return tareaDao.tareasPorEmpleadoYFecha(dni, fecha);
	}


	@Override
	public List<Tarea> tareasPorEmpleadoYMes(String dni, Integer mes, Integer anio) {
		// TODO Auto-generated method stub
		return tareaDao.tareasPorEmpleadoYMes(dni, mes, anio);
	}


	@Override
	public Tarea traer(Date fecha, Long idRequerimiento, String dni) {
		// TODO Auto-generated method stub
		return tareaDao.traer(fecha, idRequerimiento, dni);
	}


	@Override
	public Integer horasPorFecha(Date fecha, String dni) {
		// TODO Auto-generated method stub
		
		List<Tarea> tareas = tareaDao.tareasPorEmpleadoYFecha(dni,fecha);
		
		if(tareas ==null) {
			
			return 0;
		}else {
		
		Integer acumulador = 0; 
		
			for (Tarea t : tareas) {
				
				acumulador = acumulador + t.getHoras();
				
			}		
			
			return acumulador;
		
		}
	}


	@Override
	public List<Tarea> tareasPorRango(String dni, Date fechaInicio, Date fechaFin) {
		return tareaDao.tareasPorRango(dni, fechaInicio, fechaFin);
	}


	@Override
	public List<Tarea> tareasPorMes(Integer mes, Integer anio) {
		// TODO Auto-generated method stub
		return tareaDao.tareasPorMes(mes, anio);
	}


	@Override
	public List<Tarea> tareasPorRQ(long numero) {
		// TODO Auto-generated method stub
		return tareaDao.tareasPorRQ(numero);
	}

}
