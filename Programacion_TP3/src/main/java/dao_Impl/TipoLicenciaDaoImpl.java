package dao_Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.TipoLicenciaDao;
import entidad.TipoLicencia;

public class TipoLicenciaDaoImpl implements TipoLicenciaDao{
	
	private HibernateTemplate hibernateTemplate;
	
	 public TipoLicenciaDaoImpl(SessionFactory sessionFactory) {
	        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	    }

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void agregar(TipoLicencia t) {
		 hibernateTemplate.save(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void modificar(TipoLicencia t) {
		hibernateTemplate.update(t);
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminar(TipoLicencia t) {
		hibernateTemplate.delete(t);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public TipoLicencia traer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TipoLicencia> listar() {
		List<TipoLicencia> list = hibernateTemplate.loadAll(TipoLicencia.class);		
		return list;
	}
	

}
