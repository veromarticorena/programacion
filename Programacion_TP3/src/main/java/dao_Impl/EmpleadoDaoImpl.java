package dao_Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.EmpleadoDao;
import entidad.Empleado;
import entidad.Licencia;

@SuppressWarnings("deprecation")
public class EmpleadoDaoImpl implements EmpleadoDao {
	
	
	private HibernateTemplate hibernateTemplate;
	
	 public EmpleadoDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Empleado t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Empleado t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Empleado t) {
		hibernateTemplate.delete(t);		
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Empleado> listar() {
		List<Empleado> list = hibernateTemplate.loadAll(Empleado.class);		
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Empleado empleadoAutenticado(String contrasenia, Long legajo) {
		Empleado usuario = hibernateTemplate.execute(new HibernateCallback<Empleado>() {

			@Override
			public Empleado doInHibernate(Session session) {
				try {
					@SuppressWarnings({ "unchecked" })
					Query<Empleado> query = session.createQuery("from Empleado as e left join fetch e.legajo as l where l.idLegajo = " + legajo + " and l.contrasenia  = '"
							+ contrasenia + "' and e.habilitado is true");
					Empleado usuario = query.getSingleResult();

					return usuario;
				} catch (Exception ex) {
					return null;
				}
			}
			

		});

		return usuario;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Empleado empleadoPorDni(String dni) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Empleado.class);
		criteria.add(Restrictions.eq("dni", dni));
		return (Empleado) DataAccessUtils.uniqueResult(hibernateTemplate.findByCriteria(criteria));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Empleado> empleadosPorRol(long idRol) {		
		List<Empleado> lista = hibernateTemplate.execute(new HibernateCallback<List<Empleado>> () {

			@Override
			public List<Empleado> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				Query<Empleado> query = session.createQuery("from Empleado as e left join fetch e.legajo as l left join fetch l.rol as r where r.idRol = "+idRol);
				List<Empleado> empleados = query.getResultList();
				
				return empleados;
			}
			
		});
		
		return lista;
	}



}
