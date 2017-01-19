package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraAlmacen;

public interface UnidadMineraAlmacenDAO {

	List<UnidadMineraAlmacen> listaUnidadMineraAlmacen();
	List<UnidadMineraAlmacen> listaUnidadMineraAlmacenPorUnidadMinera(String idUnidadMinera);
}
