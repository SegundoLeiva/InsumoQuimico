package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraArea;

public interface UnidadMineraAreaDAO {

	List<UnidadMineraArea> listaUnidadMineraArea();
	List<UnidadMineraArea> listaUnidadMineraAreaPorUnidadMinera(String idUnidadMinera);
	public UnidadMineraArea obtieneUnidadMineraAreaPorId(String id);
}
