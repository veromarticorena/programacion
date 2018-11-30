package dao_Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.RolDao;
import entidad.Rol;

public class RolDaoImpl implements RolDao {
	
	private HibernateTemplate hibernateTemplate;
	
	 public RolDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Rol t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Rol t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Rol t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Rol traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Rol> listar() {
		List<Rol> list = hibernateTemplate.loadAll(Rol.class);		
		return list;
	}


	

}
