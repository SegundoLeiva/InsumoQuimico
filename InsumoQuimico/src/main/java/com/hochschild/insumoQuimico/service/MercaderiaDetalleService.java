package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.MercaderiaDetalle;

public interface MercaderiaDetalleService {

	public List<MercaderiaDetalle> obtenerMercaderiaDetallePorIdMercaderia(String id);
	public List<MercaderiaDetalle> obtenerMercaderiaDetalleReporte(String idUnidadMinera,String anio,String mes);
}
