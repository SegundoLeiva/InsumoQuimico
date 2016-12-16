package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMedida;

public interface UnidadMedidaDAO {

	List<UnidadMedida> listaUnidadMedida();
	public UnidadMedida obtieneUnidadMedidaPorId(String id);
}
