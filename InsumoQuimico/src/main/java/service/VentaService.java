package service;

import java.io.Serializable;
import domain.DetVen;
import domain.Venta;



public interface VentaService extends Serializable{

	public void addVenta(Venta venta);
	public void addDetVen(DetVen detVen);

}
