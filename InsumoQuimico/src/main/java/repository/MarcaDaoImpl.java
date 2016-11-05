package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.MaeTab;


@Repository(value = "marcaDao")
public class MarcaDaoImpl implements MarcaDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	
	@Transactional(readOnly = false)
	public void addMarca(MaeTab maeTab) {
		// TODO Auto-generated method stub
		em.persist(maeTab);
	}
	

	@Transactional(readOnly = false)
	public void editarmarca(MaeTab maeTab) {
		// TODO Auto-generated method stub
		em.merge(maeTab);
	}

	
	public Object[] datosmarcasbyId(Long id) {
		// TODO Auto-generated method stub
		String queryStr = "select m.id,m.codDes,m.descripcion,m.estado from MaeTab m where m.id=?1 ";
		TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
		query.setParameter(1, id);
		Object[] resultado = query.getSingleResult();
		return resultado;

	}
	public MaeTab findByMarca(Long idmar) {
		// TODO Auto-generated method stub
		
		return (MaeTab)em.createQuery("Select m from MaeTab m where m.id="+idmar+"").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<MaeTab> getlistamaetab(Integer cod) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select m.codDes,m.descripcion,m.estado,m.id from MaeTab m where m.codOpc="+cod+" and m.estado in (1,2) order by m.descripcion")
				.getResultList();
	}
}