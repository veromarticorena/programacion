package dao_Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.RqPorEmpleadoDao;
import entidad.RqPorEmpleado;

public class RqPorEmpleadoDaoImpl implements RqPorEmpleadoDao {

	private HibernateTemplate hibernateTemplate;
	
	 public RqPorEmpleadoDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(RqPorEmpleado t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(RqPorEmpleado t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(RqPorEmpleado t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public RqPorEmpleado traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<RqPorEmpleado> listar() {
		List<RqPorEmpleado> list = hibernateTemplate.loadAll(RqPorEmpleado.class);		
		return list;
	}


	
	

}
