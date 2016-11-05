package repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.MaeTab;
import domain.Producto;

@Repository(value = "productoDao")
public class ProductoDaoImpl implements ProductoDao {

	@Autowired
	@Qualifier(value="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Producto> getlista() {
		// TODO Auto-generated method stub
		List<Producto> resultado = hibernateTemplate.find("from Producto p where estado in (1,2) order by p.fecReg");
		return resultado;
	}
	
	@Transactional(readOnly = false)
	public void agregarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Date fecharegistro = new Date();
		producto.setStock(0);
		producto.setFecReg(new Timestamp(fecharegistro.getTime()));
		hibernateTemplate.persist(producto);
	}
	
	@Transactional(readOnly = false)
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		Producto producto = productoById(id);
		producto.setEstado(0);
		hibernateTemplate.merge(producto);
	}

	@Transactional(readOnly = false)
	public void editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(producto);
	}
	
	@SuppressWarnings("unchecked")
	public List<MaeTab> getlistamaetab(Integer cod) {
		// TODO Auto-generated method stub
		return hibernateTemplate
				.find("select m from MaeTab m where m.estado=1 and m.codOpc="+cod+" order by m.descripcion");
	}
	
	public Producto productoById(Long id) {
		// TODO Auto-generated method stub
		
		return (Producto) hibernateTemplate.find("from Producto where id="+id+"").get(0);
	}
}