package dao_Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.RequerimientoDao;
import entidad.Requerimiento;

public class RequerimientoDaoImpl implements RequerimientoDao{
	
	private HibernateTemplate hibernateTemplate;
	
	 public RequerimientoDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Requerimiento t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Requerimiento t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Requerimiento t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Requerimiento traer(long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Requerimiento.class, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> listar() {
		List<Requerimiento> list = hibernateTemplate.loadAll(Requerimiento.class);		
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> traerPorNumero(long numero) {
		List<Requerimiento> lista = hibernateTemplate.execute(new HibernateCallback<List<Requerimiento>> () {

			@Override
			public List<Requerimiento> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Requerimiento> query = session.createQuery("from Requerimiento where numero = "+numero);
				List<Requerimiento> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> habilitadosPorEmpleado(String dni) {		
		List<Requerimiento> lista = hibernateTemplate.execute(new HibernateCallback<List<Requerimiento>> () {

			@Override
			public List<Requerimiento> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Requerimiento> query = session.createQuery("from Requerimiento as r left join fetch r.empleado as e where r.habilitado is true and e.dni = '" +dni+"'");
				List<Requerimiento> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Requerimiento> traerPorNumeroYEmpleado(String dni, long numero) {		
		List<Requerimiento> lista = hibernateTemplate.execute(new HibernateCallback<List<Requerimiento>> () {

			@Override
			public List<Requerimiento> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Requerimiento> query = session.createQuery("from Requerimiento as r left join fetch r.empleado as e where r.habilitado is true and r.numero = "+numero+" and e.dni = '" +dni+"'");
				List<Requerimiento> requerimientos = query.getResultList();
				
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
				Query<Requerimiento> query = session.createQuery("from Requerimiento where habilitado is true");
				List<Requerimiento> requerimientos = query.getResultList();
				
				return requerimientos;
			}
			
		});
		
		return lista;
	}

}
