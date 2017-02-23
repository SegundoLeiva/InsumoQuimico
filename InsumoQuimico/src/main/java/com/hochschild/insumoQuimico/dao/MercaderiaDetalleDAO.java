package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;

public interface MercaderiaDetalleDAO {

	public void insertarMercaderiaDetalle(MercaderiaDetalle data);
	public void eliminarMercaderiaDetalle(String idMercaderia, int idMercaderiaDetalle);
	public void modificarMercaderiaDetalle(MercaderiaDetalle data);
	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id);
	public MercaderiaDetalle obtenerMercaderiaDetalle(String idMercaderia,String idMercaderiaDetalle);
	public List<MercaderiaDetalle> obtenerMercaderiaDetalleReporte(String idUnidadMinera,String anio,String mes);
}
