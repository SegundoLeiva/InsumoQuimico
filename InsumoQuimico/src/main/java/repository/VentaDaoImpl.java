package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.DetVen;
import domain.Venta;




@Repository(value = "ventaDao")
public class VentaDaoImpl implements VentaDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	
	@Transactional(readOnly = false)
	public void addVenta(Venta venta) {
		// TODO Auto-generated method stub
		em.persist(venta);
	}
	
	@Transactional(readOnly = false)
	public void addDetVen(DetVen detVen){
		// TODO Auto-generated method stub
		em.persist(detVen);
		
	}
	

}