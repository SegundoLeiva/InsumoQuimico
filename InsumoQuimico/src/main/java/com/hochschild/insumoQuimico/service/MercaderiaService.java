package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;
import com.hochschild.insumoQuimico.domain.MercaderiaParametrosEntrada;

public interface MercaderiaService {

	public void actualizarMercaderia(Mercaderia Mercaderia);
	public String guardarMercaderia(MercaderiaParametrosEntrada Mercaderia);
	public void eliminarMercaderia(String idMercaderia);
	public Mercaderia obtieneMercaderiaPorId(String id);
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaEntrada);
}
