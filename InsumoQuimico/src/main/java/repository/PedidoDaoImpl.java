package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.DetPed;
import domain.Pedido;




@Repository(value = "pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}


	
	@Transactional(readOnly = false)
	public void addPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		em.persist(pedido);
	}
	
	@Transactional(readOnly = false)
	public void addDetPed(DetPed detPed){
		// TODO Auto-generated method stub
		em.persist(detPed);
		
	}
	

}
