package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.controller.MercaderiaParametrosEntrada;
import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;

public interface MercaderiaService {

	public void actualizarMercaderia(Mercaderia Mercaderia);
	public String guardarMercaderia(MercaderiaParametrosEntrada Mercaderia);
	public void eliminarMercaderia(String idMercaderia);
	public Mercaderia obtieneMercaderiaPorId(String id);
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsulta mercaderiaConsulta, String fechaInicio, String fechaFin);
}
