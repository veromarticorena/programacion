package dao_Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.EmpleadoDao;
import entidad.Empleado;

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
	public Empleado traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Empleado> listar() {
		List<Empleado> list = hibernateTemplate.loadAll(Empleado.class);		
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Empleado empleadoAutenticado(String contrasenia, Integer legajo) {
		Empleado usuario = hibernateTemplate.execute(new HibernateCallback<Empleado>() {

			@Override
			public Empleado doInHibernate(Session session) {
				try {
					@SuppressWarnings({ "unchecked" })
					Query<Empleado> query = session.createQuery("from Empleado as e left join fetch e.legajo as l where l.idLegajo " + legajo + " and e.contrasenia  = '"
							+ contrasenia + "' and habilitado is true");
					Empleado usuario = query.getSingleResult();

					return usuario;
				} catch (Exception ex) {
					return null;
				}
			}

		});

		return usuario;
	}
	

}
