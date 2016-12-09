package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.Mercaderia;
import com.hochschild.insumoQuimico.domain.MercaderiaConsulta;
import com.hochschild.insumoQuimico.domain.MercaderiaConsultaModel;

public interface MercaderiaDAO {

	public Mercaderia obtieneMercaderiaPorId(String id);
	public void actualizarMercaderia(Mercaderia data);
	public void insertarMercaderia(Mercaderia data);
	public void eliminarMercaderia(String idMercaderia);
	public List<MercaderiaConsulta> listaMercaderiaConsulta(MercaderiaConsultaModel mercaderiaConsultaModel);
	public String obtenerCorrelativoMercaderia(String idUnidadMinera);
}
