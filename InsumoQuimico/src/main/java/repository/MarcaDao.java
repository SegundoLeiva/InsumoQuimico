package repository;

import java.util.List;

import domain.MaeTab;

public interface MarcaDao {

	public void addMarca(MaeTab maetab);
	public void editarmarca(MaeTab maetab);
	Object[] datosmarcasbyId(Long id);
	public MaeTab findByMarca(Long idmar); 
	public List<MaeTab> getlistamaetab(Integer cod);

}

