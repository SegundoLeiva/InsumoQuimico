package repository;

import java.util.List;

import domain.MaeTab;
import domain.Producto;

public interface ProductoDao {

	public List<Producto> getlista() ;
	public void agregarProducto(Producto producto);
	public void editarProducto(Producto producto);
	public void eliminarProducto(Long id);
	public List<MaeTab> getlistamaetab(Integer cod);
	public Producto productoById(Long id);
}
