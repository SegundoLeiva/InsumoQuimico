package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Proveedor;


@Repository(value = "proveedorDao")
public class ProveedorDaoImpl implements ProveedorDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	
	@Transactional(readOnly = false)
	public void addproveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		em.persist(proveedor);
	}
	

	@Transactional(readOnly = false)
	public void editarproveedor(Proveedor proveedor){
		// TODO Auto-generated method stub
		em.merge(proveedor);
	}

	
	public Object[] datosproveedorbyId(Long id) {
		// TODO Auto-generated method stub
		String queryStr = "select m.id,m.desProv,m.rucProv,m.dirProv,m.estado from Proveedor m where m.id=?1 ";
		TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
		query.setParameter(1, id);
		Object[] resultado = query.getSingleResult();
		return resultado;

	}
	public Proveedor findByProveedor(Long idprov) {
		// TODO Auto-generated method stub
		
		return (Proveedor)em.createQuery("Select m from Proveedor m where m.id="+idprov+"").getSingleResult();
	}
	

	
	public int getIdbyNombreProveedor(String prov) {
		// TODO Auto-generated method stub
		String query="Select m.id from Proveedor m where m.desProv='"+prov+"'  ";
		int q=Integer.parseInt(em.createQuery(query).getSingleResult().toString());
		return q;
	}
	

	
	@SuppressWarnings("unchecked")
	public List<Proveedor> getlistaproveedor() {
		// TODO Auto-generated method stub
		return em
				.createQuery("select m.id,m.desProv,m.rucProv,m.dirProv,m.estado from Proveedor m  order by m.desProv")
				.getResultList();
	}
}
