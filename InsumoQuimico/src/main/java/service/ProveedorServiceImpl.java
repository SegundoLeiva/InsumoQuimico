package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.ProveedorDao;
import domain.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProveedorDao proveedorDao;
	
	public void addproveedor(Proveedor proveedor){
		proveedorDao.addproveedor(proveedor);
	}
	public void editarproveedor(Proveedor proveedor){
		proveedorDao.editarproveedor(proveedor);
	}
	
	public Object[] datosproveedorbyId(Long id){
		return proveedorDao.datosproveedorbyId(id);

	}
	public Proveedor findByProveedor(Long idprov){
		return proveedorDao.findByProveedor(idprov);
	}
	public int getIdbyNombreProveedor(String prov){
		return proveedorDao.getIdbyNombreProveedor(prov);
	}
	public List<Proveedor> getlistaproveedor(){
		return proveedorDao.getlistaproveedor();

	}
}
