package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Mercaderia;

public interface MercaderiaDAO {

	public Mercaderia obtieneMercaderiaPorId(String id);
	public void actualizarMercaderia(Mercaderia data);
	public void insertarMercaderia(Mercaderia data);
	public void eliminarMercaderia(String idMercaderia);
	List<Mercaderia> listaMercaderia();
	public String obtenerCorrelativoMercaderia(String idUnidadMinera);
}
