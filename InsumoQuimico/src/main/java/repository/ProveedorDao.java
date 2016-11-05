package repository;

import java.util.List;

import domain.NroSeries;
import domain.Proveedor;;

public interface ProveedorDao {

	public void addproveedor(Proveedor proveedor);
	public void editarproveedor(Proveedor proveedor);
	public Object[] datosproveedorbyId(Long id);
	public Proveedor findByProveedor(Long idprov); 
	public List<Proveedor> getlistaproveedor();
	public int getIdbyNombreProveedor(String prov);
}
