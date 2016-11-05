package service;

import java.io.Serializable;
import java.util.List;

import domain.Proveedor;

public interface ProveedorService extends Serializable{

	public void addproveedor(Proveedor proveedor);
	public void editarproveedor(Proveedor proveedor);
	public Object[] datosproveedorbyId(Long id);
	public Proveedor findByProveedor(Long idprov); 
	public List<Proveedor> getlistaproveedor();
	public int getIdbyNombreProveedor(String prov);
}
