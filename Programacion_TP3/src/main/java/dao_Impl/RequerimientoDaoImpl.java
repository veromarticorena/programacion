package dao_Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import dao.RequerimientoDao;
import entidad.Requerimiento;
import entidad.RqPorEmpleado;

public class RequerimientoDaoImpl implements RequerimientoDao{
	
	private HibernateTemplate hibernateTemplate;
	
	 public RequerimientoDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Requerimiento t) {
		 hibernateTemplate.save(t);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Requerimiento t) {
		// TODO Auto-generated method stub
		 hibernateTemplate.update(t);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Requerimiento t) {
		 hibernateTemplate.delete(t);		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RqPorEmpleado> habilitadosPorEmpleado(String dni) {
		List<RqPorEmpleado> lista = hibernateTemplate.execute(new HibernateCallback<List<RqPorEmpleado>> () {

			@Override
			public List<RqPorEmpleado> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<RqPorEmpleado> query = session.createQuery("from RqPorEmpleado as r left join fetch r.empleado as e left join fetch r.requerimiento as rq where rq.habilitado is true and e.dni = '" +dni+"'");
				List<RqPorEmpleado> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> habilitados() {
		List<Requerimiento> lista = hibernateTemplate.execute(new HibernateCallback<List<Requerimiento>> () {

			@Override
			public List<Requerimiento> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Requerimiento> query = session.createQuery("from Requerimiento as r where r.habilitado is true");
				List<Requerimiento> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Requerimiento traerPorNumero(long numero) {
		Requerimiento lista = hibernateTemplate.execute(new HibernateCallback<Requerimiento> () {

			@Override
			public Requerimiento doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Requerimiento> query = session.createQuery("from Requerimiento as r where r.habilitado is true and r.numero = "+numero);
				Requerimiento requerimientos = query.uniqueResult();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RqPorEmpleado> asignadosPorNumero(long numero) {
		List<RqPorEmpleado> lista = hibernateTemplate.execute(new HibernateCallback<List<RqPorEmpleado>> () {

			@Override
			public List<RqPorEmpleado> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<RqPorEmpleado> query = session.createQuery("from RqPorEmpleado as r left join fetch r.requerimiento as rq where rq.habilitado is true and rq.numero = "+numero);
				List<RqPorEmpleado> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public RqPorEmpleado asignadoAEmpleado(long numero, String dni) {
		RqPorEmpleado lista = hibernateTemplate.execute(new HibernateCallback<RqPorEmpleado> () {

			@Override
			public RqPorEmpleado doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<RqPorEmpleado> query = session.createQuery("from RqPorEmpleado as r left join fetch r.requerimiento as rq left join fetch r.empleado as e where rq.habilitado is true and rq.numero = "+numero+" and e.dni = '"+dni+"'");
				RqPorEmpleado requerimientos = query.uniqueResult();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}
	 
	 

}
