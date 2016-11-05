package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import repository.PedidoDao;
import domain.DetPed;
import domain.Pedido;


@Service
public class PedidoServiceImpl implements PedidoService{
	private static final long serialVersionUID = 1L;
	@Autowired
	private PedidoDao pedidoDao;
	
	public void addPedido(Pedido pedido){
		pedidoDao.addPedido(pedido);
	}
	
	public void addDetPed(DetPed detPed){
		pedidoDao.addDetPed(detPed);
	}

}