package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.controller.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.Mercaderia;

public interface MercaderiaService {

	public void actualizarMercaderia(Mercaderia Mercaderia);
	public String guardarMercaderia(MercaderiaParametrosEntrada Mercaderia);
	public void eliminarMercaderia(String idMercaderia);
	List<Mercaderia> listaMercaderia();
	public Mercaderia obtieneMercaderiaPorId(String id);
}
