package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMedida;

public interface UnidadMedidaService {

	List<UnidadMedida> listaUnidadMedida();
	public UnidadMedida obtieneUnidadMedidaPorId(String id);
}
