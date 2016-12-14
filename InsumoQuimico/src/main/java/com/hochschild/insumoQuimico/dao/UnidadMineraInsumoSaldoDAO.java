package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldo;

public interface UnidadMineraInsumoSaldoDAO {

	public UnidadMineraInsumoSaldo obtienerStock(String idUnidadMineraInsumo,String idUnidadMineraAlmacen);
}
