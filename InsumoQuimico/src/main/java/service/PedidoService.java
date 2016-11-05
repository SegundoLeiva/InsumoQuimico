package service;

import java.io.Serializable;
import java.util.List;

import domain.DetPed;
import domain.Pedido;



public interface PedidoService extends Serializable{

	public void addPedido(Pedido pedido);
	public void addDetPed(DetPed detPed);

}
