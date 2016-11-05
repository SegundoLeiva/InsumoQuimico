package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.MaeTab;
import domain.NroSeries;
import domain.Producto;

@Repository(value = "productoDao")
public class ProductoDaoImpl implements ProductoDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Producto> getlista() {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select p.id,p.codigo,p.nombre,p.stock,p.estado from Producto p where estado in (1,2) order by p.fecReg").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<NroSeries> getSerie() {
		// TODO Auto-generated method stub
		return em
				.createQuery(
						"select n.id,n.idPro,n.nroSer from NroSeries n where n.detSer='E' ").getResultList();
	}
	
	public int getmaxidproducto() {
		// TODO Auto-generated method stub
		String query="select max(p.id) from Producto p";
		int q=Integer.parseInt(em.createQuery(query).getSingleResult().toString());
		return q;
	}
	
	public int getIdbyNombreProducto(String pro) {
		// TODO Auto-generated method stub
		String query="Select m.id from Producto m where m.nombre='"+pro+"'  ";
		int q=Integer.parseInt(em.createQuery(query).getSingleResult().toString());
		return q;
	}
	
	@Transactional(readOnly = false)
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		em.persist(producto);
	}
	
	@Transactional(readOnly = false)
	public void addNroSeries(NroSeries nroSeries){
		// TODO Auto-generated method stub
		em.persist(nroSeries);
	}
	

	@Transactional(readOnly = false)
	public void editarproducto(Producto producto) {
		// TODO Auto-generated method stub
		em.merge(producto);
	}
	@Transactional(readOnly = false)
	public void editarNroserie(NroSeries nroseries) {
		// TODO Auto-generated method stub
		em.merge(nroseries);
	}

	
	public Object[] datosproductosbyId(Long id) {
		// TODO Auto-generated method stub
		String queryStr = "select c.id,c.nombre,c.codCategoria,c.codMarca,(select m.descripcion from "
				+ "MaeTab m where c.codCategoria=m.id),(select m.descripcion from MaeTab m where c.codMarca=m.id),"
				+ "c.codigo,c.estado "
				+ "from Producto c where c.id=?1";
		TypedQuery<Object[]> query = em.createQuery(queryStr, Object[].class);
		query.setParameter(1, id);
		Object[] resultado = query.getSingleResult();
		return resultado;

	}
	public Producto findByProducto(Long idpro) {
		// TODO Auto-generated method stub
		
		return (Producto)em.createQuery("Select p from Producto p where p.id="+idpro+"").getSingleResult();
	}
	
	public NroSeries findByNroSerie(String nroSer) {
		// TODO Auto-generated method stub
		
		return (NroSeries)em.createQuery("Select p from NroSeries p where p.nroSer='"+nroSer+"' ").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<MaeTab> getlistamaetab(Integer cod) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select m from MaeTab m where m.estado=1 and m.codOpc="+cod+" order by m.descripcion")
				.getResultList();
	}
}