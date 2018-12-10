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

import dao.LicenciaDao;
import entidad.Licencia;


public class LicenciaDaoImpl implements LicenciaDao {
	
	private HibernateTemplate hibernateTemplate;
	
	 public LicenciaDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Licencia t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Licencia t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Licencia t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Licencia traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Licencia> listar() {
		List<Licencia> list = hibernateTemplate.loadAll(Licencia.class);		
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Licencia> licenciaPorEmpleado(String dni) {		
		List<Licencia> lista = hibernateTemplate.execute(new HibernateCallback<List<Licencia>> () {

			@Override
			public List<Licencia> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Licencia> query = session.createQuery("from Licencia as l left join fetch l.empleado as e where e.dni = '" +dni+"'");
				List<Licencia> licencias = query.getResultList();
				
				return licencias;
			}
			
		});
		
		return lista;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Licencia> licenciaPorEmpleadoYMes(String dni, Integer mes, Integer anio) {		
		List<Licencia> lista = hibernateTemplate.execute(new HibernateCallback<List<Licencia>> () {

			@Override
			public List<Licencia> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Licencia> query = session.createQuery("from Licencia as l left join fetch l.empleado as e where e.dni = '" +dni+"' and MONTH(l.fechaInicio) = "+mes+" and YEAR(l.fechaInicio) = "+anio);
				List<Licencia> licencias = query.getResultList();
				
				return licencias;
			}
			
		});
		
		return lista;
	}

	

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Licencia licenciaPorEmpleadoYFecha(String dni, Date fecha) {
		Licencia licencia = hibernateTemplate.execute(new HibernateCallback<Licencia>() {

			@Override
			public Licencia doInHibernate(Session session) {
				try {
					@SuppressWarnings("unchecked")
					Query<Licencia> query = session.createQuery("from Licencia as l left join fetch l.empleado as e where e.dni = '" +dni+"' and l.fechaInicio <= '"+fecha+"' and l.fechaFin >= '"+fecha+"'");
					Licencia licencia = query.getSingleResult();

					return licencia;
				} catch (Exception ex) {
					return null;
				}
			}

		});

		return licencia;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Licencia> licenciasPorMes(Integer mes, Integer anio) {		
		List<Licencia> lista = hibernateTemplate.execute(new HibernateCallback<List<Licencia>> () {

			@Override
			public List<Licencia> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Licencia> query = session.createQuery("from Licencia as l where MONTH(l.fechaInicio) = "+mes+" and YEAR(l.fechaInicio) = "+anio);
				List<Licencia> licencias = query.getResultList();
				
				return licencias;
			}
			
		});
		
		return lista;
	}

	


}
