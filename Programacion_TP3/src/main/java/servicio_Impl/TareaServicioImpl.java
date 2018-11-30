package servicio_Impl;

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

}
