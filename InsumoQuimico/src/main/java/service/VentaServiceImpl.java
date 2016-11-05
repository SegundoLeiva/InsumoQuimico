package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import repository.VentaDao;
import domain.DetVen;
import domain.Venta;


@Service
public class VentaServiceImpl implements VentaService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private VentaDao pedidoDao;
	
	public void addVenta(Venta venta){
		pedidoDao.addVenta(venta);
	}
	
	public void addDetVen(DetVen detVen){
		pedidoDao.addDetVen(detVen);
	}

}