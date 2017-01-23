package com.hochschild.insumoQuimico.service;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoArea;

public interface UnidadMineraInsumoSaldoService {

	public UnidadMineraInsumoSaldoArea obtenerStockPorArea(String idUnidadMineraArea, String idUnidadMineraInsumoPresentacion);
}
