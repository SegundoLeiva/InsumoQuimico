package repository;

import java.util.List;

import domain.DetVen;
import domain.Venta;



public interface VentaDao {

	public void addVenta(Venta venta);
	public void addDetVen(DetVen detVen);

}
