package repository;

import java.util.List;

import domain.DetPed;
import domain.Pedido;



public interface PedidoDao {

	public void addPedido(Pedido pedido);
	public void addDetPed(DetPed detPed);

}
