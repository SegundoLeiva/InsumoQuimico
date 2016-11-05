package repository;

import java.util.List;

import domain.MaeTab;
import domain.NroSeries;
import domain.Producto;

public interface ProductoDao {

	public List<Producto> getlista() ;
	public void addProducto(Producto producto);
	public void addNroSeries(NroSeries nroSeries);
	public void editarproducto(Producto producto);
	public int getmaxidproducto();
	Object[] datosproductosbyId(Long id);
	public Producto findByProducto(Long idpro); 
	public List<MaeTab> getlistamaetab(Integer cod);
	public int getIdbyNombreProducto(String pro);
	public List<NroSeries> getSerie();
	public NroSeries findByNroSerie(String nroSer);
	public void editarNroserie(NroSeries nroseries);

}
