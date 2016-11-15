package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;

public interface MercaderiaDetalleDAO {

	public void insertarMercaderiaDetalle(MercaderiaDetalle data);
	public void eliminarMercaderiaDetalle(int idMercaderiaDetalle, String idMercaderia);
	public void modificarMercaderiaDetalle(MercaderiaDetalle data);
	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id);
	public MercaderiaDetalle obtenerMercaderiaDetalle(String idSolPed,String idSolPedDetalle);
}
