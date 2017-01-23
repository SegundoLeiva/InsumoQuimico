package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoArea;

public interface UnidadMineraInsumoSaldoDAO {

	public UnidadMineraInsumoSaldoArea obtenerStockPorArea(String idUnidadMineraArea,String idUnidadMineraInsumoPresentacion);
}
