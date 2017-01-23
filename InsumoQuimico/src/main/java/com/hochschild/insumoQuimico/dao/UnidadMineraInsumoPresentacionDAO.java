package com.hochschild.insumoQuimico.dao;

import java.util.List;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoPresentacion;

public interface UnidadMineraInsumoPresentacionDAO {
	List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacion();
	List<UnidadMineraInsumoPresentacion> listaUnidadMineraInsumoPresentacionPorUnidadMinera(String idUnidadMinera);
	public UnidadMineraInsumoPresentacion obtieneUnidadMineraInsumoPresentacionPorId(String id);
}
