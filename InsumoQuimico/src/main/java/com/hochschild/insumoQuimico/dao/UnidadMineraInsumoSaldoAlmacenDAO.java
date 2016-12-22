package com.hochschild.insumoQuimico.dao;

import com.hochschild.insumoQuimico.domain.UnidadMineraInsumoSaldoAlmacen;

public interface UnidadMineraInsumoSaldoAlmacenDAO {

	public UnidadMineraInsumoSaldoAlmacen obtienerStockAlmacen(String idUnidadMineraInsumo,String idPresentacionInsumo);
}
