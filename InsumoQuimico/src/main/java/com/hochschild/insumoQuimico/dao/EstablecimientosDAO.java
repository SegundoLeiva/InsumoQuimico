package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.Establecimientos;

public interface EstablecimientosDAO {

	public Establecimientos obtieneEstablecimientosPorIdUnidadMinera(String idUnidadMinera);
}
