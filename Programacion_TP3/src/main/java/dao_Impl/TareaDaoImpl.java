package dao_Impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TareaDao;
import entidad.Tarea;


public class TareaDaoImpl implements TareaDao{
	
	private HibernateTemplate hibernateTemplate;
	
	 public TareaDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Tarea t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Tarea t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Tarea t) {
		hibernateTemplate.delete(t);		
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> listar() {
		List<Tarea> list = hibernateTemplate.loadAll(Tarea.class);		
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorEmpleado(String dni) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as l left join fetch l.empleado as e where e.dni = '" +dni+"'");
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorEmpleadoYFecha(String dni,Date fecha) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as t left join fetch t.empleado as e where e.dni = '" +dni+"' and t.fecha = '"+fecha+"'");
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorEmpleadoYMes(String dni,Integer mes, Integer anio) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as t left join fetch t.empleado as e where e.dni = '" +dni+"' and MONTH(t.fecha) = "+mes+" and YEAR(t.fecha) = "+anio);
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Tarea traer(Date fecha, Long idRequerimiento, String dni) {
		Tarea tarea = hibernateTemplate.execute(new HibernateCallback<Tarea>() {

			@Override
			public Tarea doInHibernate(Session session) {
				try {
					@SuppressWarnings("unchecked")
					Query<Tarea> query = session.createQuery("from Tarea as t left join fetch t.empleado as e left join fetch t.requerimiento as r where e.dni = '" + dni + "' and t.fecha = '"
							+ fecha + "' and r.idRequerimiento = "+idRequerimiento);
					Tarea t = query.getSingleResult();

					return t;
				} catch (Exception ex) {
					return null;
				}
			}

		});

		return tarea;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorRango(String dni, Date fechaInicio, Date fechaFin) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as t left join fetch t.empleado as e where e.dni = '" +dni+"' and t.fecha >= '"+fechaInicio+"' and t.fecha <= '"+fechaFin+"'");
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorMes(Integer mes, Integer anio) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as t where MONTH(t.fecha) = "+mes+" and YEAR(t.fecha) = "+anio);
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Tarea> tareasPorRQ(long numero) {		
		List<Tarea> lista = hibernateTemplate.execute(new HibernateCallback<List<Tarea>> () {

			@Override
			public List<Tarea> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Tarea> query = session.createQuery("from Tarea as t left join fetch t.requerimiento as r where r.idRequerimiento = "+numero);
				List<Tarea> tareas = query.getResultList();
				
				return tareas;
			}
			
		});
		
		return lista;
	}

	
	
}
