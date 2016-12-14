package com.hochschild.insumoQuimico.service;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo;

public interface UnidadMineraInsumoSaldoService {

	public UnidadMineraInsumoSaldo obtienerStock(String idUnidadMineraInsumo,String idUnidadMineraAlmacen);
}
