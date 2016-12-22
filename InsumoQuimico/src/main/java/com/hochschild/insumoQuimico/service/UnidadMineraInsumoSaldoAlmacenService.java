package com.hochschild.insumoQuimico.service;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoAlmacen;

public interface UnidadMineraInsumoSaldoAlmacenService {

	public UnidadMineraInsumoSaldoAlmacen obtienerStockAlmacen(String idUnidadMineraInsumo,String idPresentacionInsumo);
}
