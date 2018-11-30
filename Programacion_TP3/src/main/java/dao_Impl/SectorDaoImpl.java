package dao_Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.SectorDao;
import entidad.Sector;

public class SectorDaoImpl implements SectorDao {
	
	private HibernateTemplate hibernateTemplate;
	
	 public SectorDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(Sector t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(Sector t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(Sector t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Sector traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sector> listar() {
		List<Sector> list = hibernateTemplate.loadAll(Sector.class);		
		return list;
	}

}
