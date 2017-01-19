package com.hochschild.insumoQuimico.service;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;

public interface UnidadMineraAlmacenService {

	List<UnidadMineraAlmacen> listaUnidadMineraAlmacen();
	public List<UnidadMineraAlmacen> listaUnidadMineraAlmacenPorUnidadMinera(String idUnidadMinera);
}
